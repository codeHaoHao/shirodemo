package cn.lijiahao.demo.serviceImplWithRedis;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.lijiahao.demo.dao.CommentsDao;
import cn.lijiahao.demo.po.Comments;
import cn.lijiahao.demo.redis.RedisDaoImpl;
import cn.lijiahao.demo.serviceWithRedis.CommentsService;
import cn.lijiahao.demo.utils.JacksonUtils;
@Service("CommentsService")
public class CommentsServiceImpl implements CommentsService{
	protected final Logger log =LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommentsDao commentsDao;
	
	@Autowired
	private RedisDaoImpl redisDao;
	
	public Comments selectByid(String id) throws IOException {
		// TODO Auto-generated method stub
		
		Comments comments = null;
		String commentsjson=redisDao.get("comments_"+comments.getId());
		if(StringUtils.isEmpty(commentsjson)||commentsjson.equals(null)){
			comments = commentsDao.selectByid(id);
			log.info("mysql：从mysql获取comments成功");
			if(comments!=null){
				redisDao.set("comments_"+comments.getId(), JacksonUtils.bean2Json(comments));
				log.info("redis:向redis中加入comments成功");
			}
		}else {
			comments = JacksonUtils.json2Bean(commentsjson, Comments.class);
			log.info("reids:从redis缓存中获取数据成功");
		}
		return comments;
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

	public int add(Comments comments) throws IOException {
		
		if(commentsDao.add(comments)>0){
			
			redisDao.set("comments_"+comments.getId(), JacksonUtils.bean2Json(comments));
			
			return 1;
		}
		
		return 0;
	}

	public int deleteById(String id) {
		if(commentsDao.deleteById(id)>0){
			redisDao.del("comments_"+id);
			return 1;
		}
		return 0;
	}

	public int update(Comments comments) {
		if(commentsDao.update(comments)>0){
			redisDao.del("comments_"+comments.getId());
		}
		return 0;
	}

}
