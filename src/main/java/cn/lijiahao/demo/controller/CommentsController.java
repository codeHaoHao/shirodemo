package cn.lijiahao.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lijiahao.demo.po.Comments;
import cn.lijiahao.demo.po.User;
import cn.lijiahao.demo.service.CommentsService;
import cn.lijiahao.demo.utils.SnowFlake;

public class CommentsController {
	@Autowired
	private CommentsService commentsService;
	
	
	

}
