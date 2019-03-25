package cn.lijiahao.demo.serviceWithRedis;

import java.util.List;


import cn.lijiahao.demo.po.Like;

public interface LikeService {
	Like selectByid(String id);
	//Like selectByLikeTitleName(@Param("titleName")String titleName);
	List<Like> selectAll();
	List<Like> selectAllOrderPag(int begin,int size);
	int selectCountOfRows();
	int add(Like like);
	int deleteById(String id);
	int update(Like like);
}
