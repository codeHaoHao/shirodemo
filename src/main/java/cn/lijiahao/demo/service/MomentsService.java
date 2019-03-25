package cn.lijiahao.demo.service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import cn.lijiahao.demo.po.Like;
import cn.lijiahao.demo.po.Moments;

public interface MomentsService {
	List<Moments> selectAllBysys_uid(String id);
	List<Moments> selectByLikesBylikearray(List<String> likes,int begin,int size);
	int increaseAmountOfReading(Moments moments);
	Moments selectByid(String id);
	List<Moments> selectBysys_uid(String id,int begin,int size);
	List<Moments> selectBysys_cid(String id,int begin,int size);
	Moments selectByMomentsTitleName(String titleName);
	/*List<Moments> selectAll();*/
	List<Moments> selectAllOrderPage(int begin,int size);
	int selectCountOfRows();
	int add(Moments moments);
	int deleteById(String id);
	int update(Moments moments);
	List<Moments> adminSelectAllOrderPage(int begin,int size);
	int adminSelectCountOfRows();
	int cancelDeleteById(String id);
	List<Moments> searchByTitle(String title);
}
