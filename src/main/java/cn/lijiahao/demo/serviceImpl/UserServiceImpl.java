package cn.lijiahao.demo.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lijiahao.demo.dao.UserDao;
import cn.lijiahao.demo.po.User;
import cn.lijiahao.demo.service.UserService;
@Service("UserService")
public class UserServiceImpl implements UserService{
	protected final Logger log =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDao userDao;

	public User selectByid(String id) {
		// TODO Auto-generated method stub
		return userDao.selectByid(id);
	}

	public User selectByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.selectByUsername(username);
	}

	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}

	public List<User> selectAllOrderPag(int begin, int size) {
		// TODO Auto-generated method stub
		return userDao.selectAllOrderPag(begin, size);
	}

	public int selectCountOfRows() {
		// TODO Auto-generated method stub
		return userDao.selectCountOfRows();
	}

	public int add(User user) {
		// TODO Auto-generated method stub
		return userDao.add(user);
	}

	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return userDao.deleteById(id);
	}

	public int update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

}
