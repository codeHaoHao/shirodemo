package cn.lijiahao.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lijiahao.demo.po.Role;

public interface RoleService {
	Role selectByid(String id);
	List<Role> selectAll();
	List<Role> selectBysys_uid(String sys_uid);
}
