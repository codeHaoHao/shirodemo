package cn.lijiahao.demo.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lijiahao.demo.po.Moments;
import cn.lijiahao.demo.po.User;
import cn.lijiahao.demo.service.HistoryService;
import cn.lijiahao.demo.service.MomentsService;

@Controller
public class HistoryController {
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private MomentsService momentsService;
	
	/**
	 * @Description 用于跳转userHistory.jsp
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月16日 下午3:53:24
	 */
	@RequestMapping("/returnHistoryInformation.action")
	public String returnHistoryInformation(){
		
		return "user/userHistory";
	}
	
	/**
	 * @Description 用户浏览的总数
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月16日 下午3:53:49
	 */
	@RequestMapping("/userHistoryCountOfRows.action")
	@ResponseBody
	public int userHistoryCountOfRows(){
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		return historyService.selectCountOfRows(user.getId());
	}
	
	/**
	 * @Description 加载用户浏览的数据
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月16日 下午3:54:12
	 */
	@RequestMapping("/loadUserHistoryData.action")
	@ResponseBody
	public List<Moments> loadUserHistoryData(){
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		List<Moments> momentsList = null;
		List<String> historyList = historyService.selectBysys_uid(user.getId());
		if(historyList!=null&&historyList.size()!=0){
			momentsList = momentsService.selectByLikesBylikearray(historyList, 0, 8);
		}
		return momentsList;
	}
	
	/**
	 * @Description 用户浏览的分页
	 * @param page
	 * @param size
	 * @return
	 * @author 李佳浩
	 * @Date 2018年11月16日 下午3:54:26
	 */
	@RequestMapping("/historyPageable.action")
	@ResponseBody
	public List<Moments> historyPageable(int page,int size){
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		List<Moments> momentsList = null;
		List<String> historyList = historyService.selectBysys_uid(user.getId());
		
		if(historyList!=null&&historyList.size()!=0){
			momentsList = momentsService.selectByLikesBylikearray(historyList, (page-1)*8, 8);
		}
		return momentsList;
	}
}
