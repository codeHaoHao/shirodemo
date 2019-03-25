package cn.lijiahao.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lijiahao.demo.dao.LikeDao;
import cn.lijiahao.demo.po.Like;
import cn.lijiahao.demo.service.LikeService;

@Service("LikeService")
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	private LikeDao likeDao;

	public Like selectByid(String id) {
		// TODO Auto-generated method stub
		return likeDao.selectByid(id);
	}

	public List<Like> selectBySys_uid(String sys_uid) {
		// TODO Auto-generated method stub
		return likeDao.selectBySys_uid(sys_uid);
	}

	public Like selectBysys_uidAndsys_mid(String sys_uid, String sys_mid) {
		// TODO Auto-generated method stub
		return likeDao.selectBysys_uidAndsys_mid(sys_uid, sys_mid);
	}

	public List<Like> selectAll() {
		// TODO Auto-generated method stub
		return likeDao.selectAll();
	}

	public List<Like> selectAllOrderPag(int begin, int size) {
		// TODO Auto-generated method stub
		return likeDao.selectAllOrderPag(begin, size);
	}

	public int selectCountOfRows() {
		// TODO Auto-generated method stub
		return likeDao.selectCountOfRows();
	}

	public int add(Like like) {
		// TODO Auto-generated method stub
		return likeDao.add(like);
	}

	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return likeDao.deleteById(id);
	}

	public int update(Like like) {
		// TODO Auto-generated method stub
		return likeDao.update(like);
	}

	public List<Like> selectBySys_mid(String sys_mid) {
		// TODO Auto-generated method stub
		return likeDao.selectBySys_mid(sys_mid);
	}

	public List<String> selectSys_midBySys_uid(String sys_uid) {
		// TODO Auto-generated method stub
		return likeDao.selectSys_midBySys_uid(sys_uid);
	}

}
