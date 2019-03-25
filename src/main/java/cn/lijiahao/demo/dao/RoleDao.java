package cn.lijiahao.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lijiahao.demo.po.Role;

public interface RoleDao {
	Role selectByid(@Param("id")String id);
	//Role selectByRoleTitleName(@Param("titleName")String titleName);
	List<Role> selectAll();
	List<Role> selectBysys_uid(@Param("sys_uid")String sys_uid);
	/*int selectCountOfRows();
	int add(Role role);
	int deleteById(@Param("id")String id);
	int update(Role role);*/
}
