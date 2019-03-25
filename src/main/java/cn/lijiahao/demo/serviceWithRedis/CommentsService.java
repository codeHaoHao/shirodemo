package cn.lijiahao.demo.serviceWithRedis;

import java.io.IOException;
import java.util.List;


import cn.lijiahao.demo.po.Comments;

public interface CommentsService {
	Comments selectByid(String id) throws IOException;
	//Comments selectByCommentsName(@Param("name")String name);
	List<Comments> selectAll();
	List<Comments> selectAllOrderPag(int begin,int size);
	int selectCountOfRows();
	int add(Comments comments) throws IOException;
	int deleteById(String id);
	int update(Comments comments);
}
