package cn.lijiahao.demo.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lijiahao.demo.po.Moments;
import cn.lijiahao.demo.po.User;
import cn.lijiahao.demo.service.CategoryService;
import cn.lijiahao.demo.service.MomentsService;
import cn.lijiahao.demo.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService	userService;
	@Autowired
	private MomentsService momentsService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/adminIndex.action")
	public String adminIndex(Model model){
		return "admin/adminIndex";
	}
	
	@RequestMapping("/adminCountOfUsers.action")
	@ResponseBody
	public int adminCountOfUsers(){
		return userService.selectCountOfRows();
	}
	@RequestMapping("/loadAdminManagerUsersData.action")
	@ResponseBody
	public List<User> loadAdminManagerUsersData(){
		List<User> users = userService.selectAllOrderPag(0, 15);
		return users;
	}
	
	@RequestMapping("/adminManagerUsersPageable.action")
	@ResponseBody
	public List<User> adminManagerUsersPageable(int page,int size){
		List<User> users = userService.selectAllOrderPag((page-1)*15, 15);
		return users;
	}
	@RequestMapping("/adminManagerMoments.action")
	public String adminManagerMoments(){
		return "admin/adminManagerMoments";
	}
	@RequestMapping("/adminCountOfMoments.action")
	@ResponseBody
	public int adminCountOfMoments(){
		return momentsService.adminSelectCountOfRows();
	}
	
	@RequestMapping("/loadAdminManagerMomentsData.action")
	@ResponseBody
	public List<Moments> loadAdminManagerMomentsData(){
		List<Moments> moments = momentsService.adminSelectAllOrderPage(0, 15);
		for(Moments moment:moments){
			moment.setAuthorName(userService.selectByid(moment.getSys_uid()).getName());
			moment.setCategoryName(categoryService.selectByid(moment.getSys_cid()).getName());
			if(moment.getTranspondBy()!=null&&!moment.getTranspondBy().equals("")){
				moment.setTranspondByName(userService.selectByid(moment.getTranspondBy()).getName());
			}
		}
		return moments;
	}
	
	@RequestMapping("/adminManagerMomentsPageable.action")
	@ResponseBody
	public List<Moments> adminManagerMomentsPageable(int page,int size){
		List<Moments> moments = momentsService.adminSelectAllOrderPage((page-1)*15, 15);
		for(Moments moment:moments){
			moment.setAuthorName(userService.selectByid(moment.getSys_uid()).getName());
			moment.setCategoryName(categoryService.selectByid(moment.getSys_cid()).getName());
			if(moment.getTranspondBy()!=null&&!moment.getTranspondBy().equals("")){
				moment.setTranspondByName(userService.selectByid(moment.getTranspondBy()).getName());
			}
		}
		return moments;
	}
	/**
	 * @Description	删除用户
	 * @param id
	 * @return
	 * @author 
	 * @Date 2019年3月20日 下午6:08:59
	 */
	@RequestMapping("/deleteUser.action")
	@ResponseBody
	public String deleteUser(String id){
		User user = new User();
		user.setId(id);
		user.setLocked("1");
		userService.update(user);
		return "1";
	}
	
	/**
	 * @Description 修改密码
	 * @param id
	 * @param newPassword
	 * @param salt
	 * @return
	 * @author
	 * @Date 2019年3月20日 下午8:16:04
	 */
	@RequestMapping("/editUserNewPassword.action")
	@ResponseBody
	public String editUserNewPassword(String id,String newPassword,String salt){
		User user = new User();
		user.setId(id);
		Md5Hash md5 = new Md5Hash(newPassword, salt, 1);
		String password = md5.toString();
		user.setPassword(password);
		if(userService.update(user)>0)
			return password;
		else
			return "0";	
	}
	
	@RequestMapping(value="/editUserInformation.action",method=RequestMethod.POST)
	@ResponseBody
	public User editUserInformation(HttpServletRequest request,String id,String username,String name,String age,String gender){
		try {
			String keyword = new String(request.getParameter("name").getBytes("ISO-8859-1"), "utf-8");
			System.out.println(keyword);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name);
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setName(name);
		if(age!=null&&age!="")user.setAge(Integer.parseInt(age));
		
		if(gender.equals("1")){
			user.setGender("男");
		}else if(gender.equals("0")){
			user.setGender("女");
		}
		if(userService.update(user)>0){
			return userService.selectByid(id);
		}else {
			return null;
		}
	}
	@RequestMapping("adminDeleteMoments.action")
	@ResponseBody
	public String adminDeleteMoments(String id){
		Moments moments = new Moments();
		moments.setId(id);
		moments.setIsdelete(1);
		if(momentsService.update(moments)>0){
			return "1";
		}
		return "0";
	}
	
	@RequestMapping("adminCancelDeleteMoments.action")
	@ResponseBody
	public String adminCancelDeleteMoments(String id){
		if(momentsService.cancelDeleteById(id)>0){
			return "1";
		}
		return "0";
	}
	@RequestMapping("searchByUsername.action")
	@ResponseBody
	public List<User> searchByUsername(String username){
		List<User> list = new ArrayList<User>();
		User user = userService.selectByUsername(username);
		if(user!=null){
			list.add(user);
			return list;
		}
		return null;
	}
	@RequestMapping("searchByTitle.action")
	@ResponseBody
	public List<Moments> searchByTitle(String title){
		List<Moments> list = momentsService.searchByTitle(title);
		if(list!=null){
			return list;
		}
		return null;
	}
}
