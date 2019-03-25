package cn.lijiahao.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lijiahao.demo.po.Comments;

public interface CommentsDao {
	Comments selectByid(@Param("id")String id);
	//Comments selectByCommentsName(@Param("name")String name);
	List<Comments> selectBysys_mid(@Param("sys_mid")String sys_mid);
	List<Comments> selectAll();
	List<Comments> selectAllOrderPag(@Param("begin")int begin,@Param("size")int size);
	int selectCountOfRows();
	int add(Comments comments);
	int deleteById(@Param("id")String id);
	int update(Comments comments);
}
