package cn.lijiahao.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lijiahao.demo.po.User;

public interface UserDao {
	
	User selectByid(@Param("id")String id);
	User selectByUsername(@Param("username")String username);
	List<User> selectAll();
	List<User> selectAllOrderPag(@Param("begin")int begin,@Param("size")int size);
	int selectCountOfRows();
	int add(User user);
	int deleteById(@Param("id")String id);
	int update(User user);
	
	
}
