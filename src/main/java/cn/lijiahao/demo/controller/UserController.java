package cn.lijiahao.demo.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.lijiahao.demo.po.Category;
import cn.lijiahao.demo.po.Like;
import cn.lijiahao.demo.po.Moments;
import cn.lijiahao.demo.po.User;
import cn.lijiahao.demo.service.CategoryService;
import cn.lijiahao.demo.service.LikeService;
import cn.lijiahao.demo.service.MomentsService;
import cn.lijiahao.demo.service.UserService;
import cn.lijiahao.demo.utils.SnowFlake;


/**
 * @Description
 * @author 李佳浩
 * @Date 2018年11月9日 上午11:50:11
 */
@Controller
public class UserController {
	protected final Logger log =LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userServcie;
	
	@Autowired
	private MomentsService momentsService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private LikeService likeService;
	private final String dirPath = "E:/upload/uploadImages/";
	private final String avatar_dirPath = "E:/upload/uploadImages/avatar/";
	/**
	 * @Description 用户登录
	 * @param username 用户名
	 * @param password	密码
	 * @return
	 * @author 李佳浩
	 * @Date 2018年10月13日 下午6:39:01
	 */
	@RequestMapping("/login.action")
	public String login(HttpServletRequest request,HttpServletResponse response)throws Exception{
		response.setHeader("content-type", "text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String exceptionClassName = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
				
				if(exceptionClassName!=null){
					if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
						
						out.print("<script>if(confirm('账号不存在'))window.location='/shirodemo/login.action'</script>");
						out.flush();
						out.close();
					} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
						out.print("<script>if(confirm('密码错误'))window.location='/shirodemo/login.action'</script>");
						out.flush();
						out.close();
					}  else if(DisabledAccountException.class.getName().equals(exceptionClassName)){
						out.print("<script>if(confirm('您的账号被锁定了'))window.location='/shirodemo/login.action'</script>");
						out.flush();
						out.close();
					}
				}
				return "login";
	}
	/**
	 * @Description 用户注册
	 * @param username 用户名
	 * @param password 密码
	 * @param name 姓名
	 * @return
	 * @author 李佳浩
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @Date 2018年10月15日 下午3:22:27
	 */
	@RequestMapping("/register.action")
	@ResponseBody
	public String register(String username,String password,String name) throws JsonParseException, JsonMappingException, IOException{
			if(userServcie.selectByUsername(username)!=null){
				return "0";
			}else {
				User user = new User();
				user.setId(SnowFlake.snowflake.nextId()+"");
				user.setUsername(username);
				user.setAvatar("/uploadImages/avatar/defaultAvatar.jpg");
				//用md5加密算法验算密码
				String salt = "iaeiwfsjkfhewui";
				Md5Hash md5 = new Md5Hash(password, salt, 1);
				user.setPassword(md5.toString());
				user.setName(name);
				userServcie.add(user);
				return "1";
			}
	}
	/**
	 * @Description 显示first.jsp页面的方法
	 * @param model
	 * @param request
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月9日 上午11:52:00
	 */
	@RequestMapping("/index.action")
	public String index(Model model, String type,HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
		if(subject!=null&&subject.hasRole("admin")){
			return "redirect:/adminIndex.action";
		}
		List<Category> list = categoryService.selectAll();
		List<Moments> momentsList = null;
		if(type!=null){
			momentsList = momentsService.selectBysys_cid(type, 0, 12);
		}else {
			momentsList = momentsService.selectAllOrderPage(0, 12);
		}
		model.addAttribute("type", type);
		model.addAttribute("momentsList", momentsList);
		model.addAttribute("categoryList", list);
		
		return "first";
	}
	/** 
	 * @Description 用于页面跳转
	 * @param request
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月9日 上午11:51:32
	 */
	@RequestMapping("/userIndex.action")
	public String userIndex(Model model,HttpServletRequest request){
		int countOfReading = 0;
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		List<Moments> momentsList = momentsService.selectAllBysys_uid(user.getId());
		List<Like> likes = likeService.selectBySys_uid(user.getId());
		if(momentsList==null||momentsList.size()==0){

		}else {
			for(Moments moment:momentsList){
				countOfReading+=moment.getAmountOfReading();
			}
		}
		model.addAttribute("countOfReading", countOfReading);
		model.addAttribute("likeCounts", likes.size());
		
		return "/user/userIndex";
	}
	/** 
	 * @Description 用于页面跳转
	 * @param request
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月9日 上午11:51:32
	 */
	@RequestMapping("/test.action")
	public String test(HttpServletRequest request){
		
				return "test";
	}
	/** 
	 * @Description 用于页面跳转
	 * @param request
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月9日 上午11:51:32
	 */
	@RequestMapping("/success.action")
	public String success(HttpServletRequest request){
		
				return "success";
	}
	
	/** 
	 * @Description 用于页面跳转
	 * @param request
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月9日 上午11:51:32
	 */
	@RequestMapping("/unauthorized.action")
	public String unauthorized(HttpServletRequest request){
		
				return "unauthorized";
	}
	
	/**
	 * @Description 显示userPublishMoments.jsp页面的方法
	 * @param model
	 * @param request
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月9日 上午11:50:52
	 */
	@RequestMapping("/returnUserPublisMoments.action")
	public String returnUserPublisMoments(Model model,HttpServletRequest request){
		List<Category> list = categoryService.selectAll();
		model.addAttribute("categoryList", list);
		
		return "user/userPublishMoments";
	}
	
	/**
	 * @Description 显示userMoments.jsp页面的方法
	 * @param model	视图
	 * @param request
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月9日 上午11:50:14
	 */
	@RequestMapping("/userMoments.action")
	public String userMoments(Model model,HttpServletRequest request){
				
				return "/user/userMoments";
	}
	/**
	*
	*@Description usermoments.jsp页面上的数据，此方法用于与vue交互数据
	*@param 
	*@author 李佳浩
	*@Date 2018年11月10日 上午10:29:38
	*/
	@RequestMapping("/loadUserMomentsData.action")
	@ResponseBody
	public List<Moments> loadUserMomentsData(){
		User user =  (User) SecurityUtils.getSubject().getPrincipal();
		List<Moments> list=null;
		list = momentsService.selectBysys_uid(user.getId(),0,6);
		return list;	
	}
	
	/**
	 * @Description 用于实现分页
	 * @param page
	 * @param size
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月10日 下午7:54:26
	 */
	@RequestMapping("/pageable.action")
	@ResponseBody
	public List<Moments> pageable(String page,String size){
		
		User user =  (User) SecurityUtils.getSubject().getPrincipal();
		List<Moments> list = momentsService.selectBysys_uid(user.getId(), (Integer.parseInt(page)-1)*6, Integer.parseInt(size));
		return list;
	}
	/**
	 * @Description 文章的总数
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月14日 下午3:51:34
	 */
	@RequestMapping("/countOfRows.action")
	@ResponseBody
	public int countOfRows(){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		List<Moments> moments = momentsService.selectAllBysys_uid(user.getId());
		return moments.size();
	}
	/**
	 * @Description 用户发表文章的方法
	 * @param title 文章标题
	 * @param sys_cid 文章类型ID
	 * @param content 文章内容
	 * @param slogan 文章标语
	 * @param request request
	 * @return
	 * @throws IOException
	 * @author 李佳浩
	 * @Date 2018年11月9日 上午11:48:46
	 */
	@RequestMapping("/userPublishMoments.action")
	@ResponseBody
	public String userPublishMoments(String title,String sys_cid,String content,String slogan,@RequestParam("photo") MultipartFile uploadfile,HttpServletRequest request) throws IOException{
		int success = 0;
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		String sys_uid = user.getId();
		String id = SnowFlake.snowflake.nextId()+"";
		Date time = new Date();
		Timestamp timestamp = new Timestamp(time.getTime());
		Moments moments = new Moments(id, sys_uid, sys_cid, title, slogan,content, timestamp);
		//判断所上传文件是否存在
		if(!uploadfile.isEmpty()){
			//获取上传文件的原始名称
			String originalFilename = uploadfile.getOriginalFilename();
			//设置上传文件的保存地址目录
			File filePath = new File(dirPath);
			//如果保存文件的地址不存在，就先创建目录
			if(!filePath.exists())filePath.mkdirs();
			//使用UUID重新命名上传的文件名称（uuid_原始文件名称）
			String newFilename = UUID.randomUUID()+"_"+originalFilename;
			try {
				//使用MultipartFile接口的方法完成文件上传到指定位置
				uploadfile.transferTo(new File(dirPath+newFilename));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			moments.setImage("/uploadImages/"+newFilename);
		}else {
			moments.setImage("/uploadImages/"+"default.jpg");
		}
		
		success=momentsService.add(moments);
		return success+"";
	}
	/**
	 * @Description 跳转userLikeMoments.jsp页面
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月14日 下午3:52:01
	 */
	@RequestMapping("/userLikeMoments.action")
	public String returnUserLikeMoments(){
		return "user/userLikeMoments";
	}
	@RequestMapping("/userEditSelfInformation.action")
	public String userEditSelfInformation(){
		return "user/userEditSelfInformation";
	}
	@RequestMapping("doUserEditSelfInformation.action")
	@ResponseBody
	public String doUserEditSelfInformation(String name,int age,String gender,String individualResume,@RequestParam("photo") MultipartFile uploadfile){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		user.setAge(age);
		user.setName(name);
		if(gender.equals("1")){
			user.setGender("男");
		}else if(gender.equals("0")){
			user.setGender("女");
		}
		user.setIndividualResume(individualResume);
				//判断所上传文件是否存在
				if(!uploadfile.isEmpty()){
					//获取上传文件的原始名称
					String originalFilename = uploadfile.getOriginalFilename();
					//设置上传文件的保存地址目录
					File filePath = new File(avatar_dirPath);
					//如果保存文件的地址不存在，就先创建目录
					if(!filePath.exists())filePath.mkdirs();
					//使用UUID重新命名上传的文件名称（uuid_原始文件名称）
					String newFilename = UUID.randomUUID()+"_"+originalFilename;
					try {
						//使用MultipartFile接口的方法完成文件上传到指定位置
						uploadfile.transferTo(new File(avatar_dirPath+newFilename));
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					user.setAvatar("/uploadImages/avatar/"+newFilename);
				}else {
					user.setAvatar("/uploadImages/avatar/"+"defaultAvatar.jpg");
				}
		userServcie.update(user);
		return "1";
	}
}
