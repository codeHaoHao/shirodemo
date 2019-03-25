package cn.lijiahao.demo.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lijiahao.demo.po.Like;
import cn.lijiahao.demo.po.Moments;
import cn.lijiahao.demo.po.User;
import cn.lijiahao.demo.service.LikeService;
import cn.lijiahao.demo.service.MomentsService;
import cn.lijiahao.demo.utils.SnowFlake;

@Controller
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	@Autowired
	private MomentsService momentsService;
	
	/**
	 * @Description 用户点赞操作的action
	 * @param sys_mid
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月14日 下午3:49:24
	 */
	@RequestMapping("userLike.action")
	@ResponseBody
	public String userLike(String sys_mid){
		System.out.println(sys_mid);
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		Like like = likeService.selectBysys_uidAndsys_mid(user.getId(), sys_mid);
		if(like==null){
			String id = SnowFlake.snowflake.nextId()+"";
			like = new Like(id, user.getId(), sys_mid, 1);
			likeService.add(like);
			return "1";
		}else {
			if(like.getIslike()==1){
				like.setIslike(0);
			}
			else {
				like.setIslike(1);
			}
			likeService.deleteById(like.getId());
			return "0";
		}
		
	}
	/**
	 * @Description 返回用户喜欢的文章的数量
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月14日 下午3:49:55
	 */
	@RequestMapping("/userLikeCountOfRows.action")
	@ResponseBody
	public int userLikeCountOfRows(){
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		List<Like> likes = likeService.selectBySys_uid(user.getId());
		return likes.size();
	}
	/**
	 * @Description vue.js的mounted方法初始化用户喜欢的数据时用到的action
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月14日 下午3:50:14
	 */
	@RequestMapping("/loadUserLikesData.action")
	@ResponseBody
	public List<Moments> loadUserLikesData(){
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		
		List<String> likes = likeService.selectSys_midBySys_uid(user.getId());
		
		List<Moments> momentsList = momentsService.selectByLikesBylikearray(likes, 0, 8);
		return momentsList;
	}
	/**
	 * @Description 用户喜欢的文章分页
	 * @param begin
	 * @param size
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月14日 下午3:51:04
	 */
	@RequestMapping("/likesPageable.action")
	@ResponseBody
	public List<Moments> likesPageable(int page,int size){
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		List<String> likes = likeService.selectSys_midBySys_uid(user.getId());
		List<Moments> momentsList = momentsService.selectByLikesBylikearray(likes, (page-1)*8, 8);
		return momentsList;
	}
}
