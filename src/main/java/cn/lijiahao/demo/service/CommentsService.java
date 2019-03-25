package cn.lijiahao.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lijiahao.demo.po.Comments;

public interface CommentsService {
	Comments selectByid(String id) ;
	//Comments selectByCommentsName(@Param("name")String name);
	List<Comments> selectBysys_mid(String sys_mid);
	List<Comments> selectAll();
	List<Comments> selectAllOrderPag(int begin,int size);
	int selectCountOfRows();
	int add(Comments comments);
	int deleteById(String id);
	int update(Comments comments);
}
