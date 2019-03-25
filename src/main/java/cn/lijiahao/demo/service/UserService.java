package cn.lijiahao.demo.service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import cn.lijiahao.demo.po.User;

public interface UserService {
	User selectByid(String id);
	User selectByUsername(String username);
	List<User> selectAll();
	List<User> selectAllOrderPag(int begin,int size);
	int selectCountOfRows();
	int add(User user);
	int deleteById(String id);
	int update(User user);
}
