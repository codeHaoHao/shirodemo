package cn.lijiahao.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lijiahao.demo.dao.RoleDao;
import cn.lijiahao.demo.po.Role;
import cn.lijiahao.demo.service.RoleService;
@Service("RoleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;
	
	public Role selectByid(String id) {
		// TODO Auto-generated method stub
		return roleDao.selectByid(id);
	}

	public List<Role> selectAll() {
		// TODO Auto-generated method stub
		return roleDao.selectAll();
	}

	public List<Role> selectBysys_uid(String sys_uid) {
		// TODO Auto-generated method stub
		return roleDao.selectBysys_uid(sys_uid);
	}
	
}
