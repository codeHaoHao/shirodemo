package cn.lijiahao.demo.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lijiahao.demo.po.Category;
import cn.lijiahao.demo.po.Comments;
import cn.lijiahao.demo.po.History;
import cn.lijiahao.demo.po.Like;
import cn.lijiahao.demo.po.Moments;
import cn.lijiahao.demo.po.User;
import cn.lijiahao.demo.service.CategoryService;
import cn.lijiahao.demo.service.CommentsService;
import cn.lijiahao.demo.service.HistoryService;
import cn.lijiahao.demo.service.LikeService;
import cn.lijiahao.demo.service.MomentsService;
import cn.lijiahao.demo.service.UserService;
import cn.lijiahao.demo.utils.SnowFlake;

/**
*
*@Description 处理moments的controller层
*@author 
*@Date 2018年11月9日 上午11:55:52
*/
@Controller
public class MomentsController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MomentsService momentsService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CommentsService commentsService;
	
	@Autowired
	private LikeService likeService;
	
	@Autowired
	private HistoryService historyService;
	
	/**
	 * @Description	first.jsp页面中点击加载新内容的方法
	 * @param model
	 * @param begin 开始
	 * @param size	查询的长度
	 * @return 返回list列表
	 * @author 
	 * @Date 2018年11月9日 上午11:52:41
	 */
	@RequestMapping("/loadmore.action")
	@ResponseBody
	public List<Moments> loadmore(Model model,String begin,String size,String type){
		
		List<Moments> list =null;
		if(type==null||type.equals("")){
			list = momentsService.selectAllOrderPage(Integer.parseInt(begin), Integer.parseInt(size));
		}else {
			list = momentsService.selectBysys_cid(type,Integer.parseInt(begin), Integer.parseInt(size));
		}
		//Moments moments = momentsService.selectByid("256761629088288768");
		return list;
	}
	
	/**
	 * @Description 发布评论
	 * @param model
	 * @param sys_mid
	 * @param content
	 * @author 
	 * @Date 2018年11月13日 下午4:06:44
	 */
	@RequestMapping(value="/publishComments.action",method = RequestMethod.GET)
	public String publishComments(Model model,String sys_mid,String content){
		System.out.println(content);
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		String id = SnowFlake.snowflake.nextId()+"";
		Comments comments = new Comments(id, sys_mid, user.getId(), content, "0");
		commentsService.add(comments);
		return "redirect:news.action?momentsId="+sys_mid;
	}
	/**
	 * @Description	显示news.jsp的方法
	 * @param model
	 * @param momentsId 前端请求发送的moments的id
	 * @param request
	 * @return
	 * @author 
	 * @Date 2018年11月9日 上午11:54:03
	 */
	@RequestMapping("/news.action")
	public String news(Model model,String momentsId){
		List<Category> list = categoryService.selectAll();
		List<Moments> momentsList = null;
		List<Like> likes = likeService.selectBySys_mid(momentsId);
		Moments moments = momentsService.selectByid(momentsId);
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		if(user!=null){
			History history = null;
			history = historyService.selectHistoryBysys_midAndsys_uid(momentsId, user.getId());
			if(history!=null){
				Timestamp timestamp = new Timestamp(new Date().getTime());
				history.setHistoryTime(timestamp);
				historyService.update(history);
			}else{
				history = new History(SnowFlake.snowflake.nextId()+"", user.getId(), momentsId, null);
				historyService.add(history);
			}
		}
		
		Category category = categoryService.selectByid(moments.getSys_cid());
		momentsList = momentsService.selectBysys_uid(moments.getSys_uid(),0,7);
		List<Comments> commentsList = commentsService.selectBysys_mid(momentsId);
		momentsService.increaseAmountOfReading(moments);
		User author = null;
		if(moments.getTranspondBy()!=null){
			author = userService.selectByid(moments.getTranspondBy());
		}else{
			author = userService.selectByid(moments.getSys_uid());
		}
		model.addAttribute("momentsList", momentsList);
		model.addAttribute("category", category);
		model.addAttribute("categoryList", list);
		model.addAttribute("moments", moments);
		model.addAttribute("commentsList", commentsList);
		model.addAttribute("likeCounts",likes.size());
		model.addAttribute("author", author);
		return "news";
	}
	
	
	
	/**
	 * @Description 获取文章的评论
	 * @param sys_mid
	 * @return
	 * @author 
	 * @Date 2018年11月14日 下午3:49:11
	 */
	@RequestMapping("/getMomentsComments.action")
	@ResponseBody
	public List<Comments> getMommentsComments(String sys_mid){
		System.out.println(sys_mid);
		List<Comments> commentsList = null;
		commentsList = commentsService.selectBysys_mid(sys_mid);
		return commentsList;
	}
	
	/**
	 * @Description 通过id删除moments
	 * @param id
	 * @return
	 * @author 
	 * @Date 2018年11月10日 下午12:48:13
	 */
	
	@RequestMapping("deleteMomentsById.action")
	@ResponseBody
	public String deleteMomentsById(String id){
		System.out.println(id);
		int success = momentsService.deleteById(id);
		return success+"";
	}
	@RequestMapping("transpondMoment.action")
	@ResponseBody
	public String transpond(String id){
		System.out.println(id);
		Moments moment2=momentsService.selectByid(id);
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		Timestamp timestamp = new Timestamp(new Date().getTime());
		Moments moment = new Moments(id, user.getId(), moment2.getSys_cid(), moment2.getTitle(), moment2.getSlogan()
				, moment2.getContent(), timestamp);
		moment.setImage(moment2.getImage());
		moment.setId(SnowFlake.snowflake.nextId()+"");
		moment.setTranspondBy(moment2.getSys_uid());
		momentsService.add(moment);
		return "1";
	}
	@RequestMapping("userAllMoments.action")
	public String allUserMomnets(Model model,String id){
		model.addAttribute("id", id);
		User author = userService.selectByid(id);
		model.addAttribute("author", author);
		return "userAllMoments";
	}
	@RequestMapping("userAllMomentsCountOfRows.action")
	@ResponseBody
	public int userAllMomentsCountOfRows(Model model,String id){
		List<Moments> moments = momentsService.selectAllBysys_uid(id);
		return moments.size();
	}
	
	
	@RequestMapping("loadUserAllMomentsData.action")
	@ResponseBody
	public List loadUserAllMomentsData(Model model,String id){
		List<Moments> moments = momentsService.selectBysys_uid(id, 0, 8);
		return moments;
	}
	
	@RequestMapping("/userAllMomentsPageable.action")
	@ResponseBody
	public List<Moments> likesPageable(String id,int page,int size){
		List<Moments> moments = momentsService.selectBysys_uid(id, (page-1)*8, 8);
		return moments;
	}
}
