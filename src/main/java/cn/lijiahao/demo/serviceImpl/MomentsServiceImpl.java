package cn.lijiahao.demo.serviceImpl;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lijiahao.demo.dao.MomentsDao;
import cn.lijiahao.demo.po.Like;
import cn.lijiahao.demo.po.Moments;
import cn.lijiahao.demo.service.MomentsService;
@Service("MomentsService")
public class MomentsServiceImpl implements MomentsService{

	@Autowired
	private MomentsDao momentsDao;
	
	private Lock lock;
	
	public MomentsServiceImpl() {
		lock = new ReentrantLock();// 锁对象 
	}

	public Moments selectByid(String id) {
		// TODO Auto-generated method stub
		return momentsDao.selectByid(id);
	}

	public List<Moments> selectBysys_uid(String id,int begin,int size) {
		// TODO Auto-generated method stub
		return momentsDao.selectBysys_uid(id, begin, size);
	}

	public Moments selectByMomentsTitleName(String titleName) {
		// TODO Auto-generated method stub
		return momentsDao.selectByMomentsTitleName(titleName);
	}

	public List<Moments> selectAllOrderPage(int begin, int size) {
		// TODO Auto-generated method stub
		return momentsDao.selectAllOrderPage(begin, size);
	}

	public int add(Moments moments) {
		// TODO Auto-generated method stub
		return momentsDao.add(moments);
	}

	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return momentsDao.deleteById(id);
	}

	public int update(Moments moments) {
		// TODO Auto-generated method stub
		return momentsDao.update(moments);
	}

	public int increaseAmountOfReading(Moments moments) {
		 lock.lock();// 得到锁
	 try{
		 moments.setAmountOfReading(moments.getAmountOfReading()+1);
		 return momentsDao.increaseAmountOfReading(moments);
	 }finally{
			 lock.unlock();//释放锁
		 }	
		
		
	}

	public List<Moments> selectBysys_cid(String id, int begin, int size) {
		// TODO Auto-generated method stub
		return momentsDao.selectBysys_cid(id, begin, size);
	}

	public int selectCountOfRows() {
		// TODO Auto-generated method stub
		return momentsDao.selectCountOfRows();
	}

	public List<Moments> selectByLikesBylikearray(List<String> likes, int begin, int size) {
		// TODO Auto-generated method stub
		return momentsDao.selectByLikesBylikearray(likes, begin, size);
	}

	public List<Moments> selectAllBysys_uid(String id) {
		// TODO Auto-generated method stub
		return momentsDao.selectAllBysys_uid(id);
	}

	public List<Moments> adminSelectAllOrderPage(int begin, int size) {
		// TODO Auto-generated method stub
		return momentsDao.adminSelectAllOrderPage(begin, size);
	}

	public int adminSelectCountOfRows() {
		// TODO Auto-generated method stub
		return momentsDao.adminSelectCountOfRows();
	}

	public int cancelDeleteById(String id) {
		// TODO Auto-generated method stub
		return momentsDao.cancelDeleteById(id);
	}

	public List<Moments> searchByTitle(String title) {
		// TODO Auto-generated method stub
		return momentsDao.searchByTitle(title);
	}
	
}
