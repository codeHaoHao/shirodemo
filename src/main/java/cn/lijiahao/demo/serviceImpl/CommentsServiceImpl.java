package cn.lijiahao.demo.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lijiahao.demo.dao.CommentsDao;
import cn.lijiahao.demo.po.Comments;
import cn.lijiahao.demo.service.CommentsService;
@Service("CommentsService")
public class CommentsServiceImpl implements CommentsService{
	protected final Logger log =LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommentsDao commentsDao;
	
	public Comments selectByid(String id) {
		// TODO Auto-generated method stub
		return commentsDao.selectByid(id);
	}
	public List<Comments> selectAll() {
		// TODO Auto-generated method stub
		return commentsDao.selectAll();
	}
	public List<Comments> selectAllOrderPag(int begin, int size) {
		// TODO Auto-generated method stub
		return commentsDao.selectAllOrderPag(begin, size);
	}
	public int selectCountOfRows() {
		// TODO Auto-generated method stub
		return commentsDao.selectCountOfRows();
	}
	public int add(Comments comments) {
		// TODO Auto-generated method stub
		return commentsDao.add(comments);
	}
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return commentsDao.deleteById(id);
	}
	public int update(Comments comments) {
		// TODO Auto-generated method stub
		return commentsDao.update(comments);
	}
	public List<Comments> selectBysys_mid(String sys_mid) {
		// TODO Auto-generated method stub
		return commentsDao.selectBysys_mid(sys_mid);
	}
	
	

}
