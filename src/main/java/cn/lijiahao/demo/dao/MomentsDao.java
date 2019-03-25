package cn.lijiahao.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lijiahao.demo.po.Like;
import cn.lijiahao.demo.po.Moments;

public interface MomentsDao {
	List<Moments> selectByLikesBylikearray(@Param("likes")List<String> likes,@Param("begin")int begin,@Param("size")int size);
	int increaseAmountOfReading(Moments moments);
	Moments selectByid(@Param("id")String id);
	List<Moments> selectAllBysys_uid(@Param("id")String id);
	List<Moments> selectBysys_uid(@Param("id")String id,@Param("begin")int begin,@Param("size")int size);
	List<Moments> selectBysys_cid(@Param("id")String id,@Param("begin")int begin,@Param("size")int size);
	Moments selectByMomentsTitleName(@Param("titleName")String titleName);
	List<Moments> selectAll();
	List<Moments> selectAllOrderPage(@Param("begin")int begin,@Param("size")int size);
	List<Moments> adminSelectAllOrderPage(@Param("begin")int begin,@Param("size")int size);
	int selectCountOfRows();
	int adminSelectCountOfRows();
	int add(Moments moments);
	int deleteById(@Param("id")String id);
	int update(Moments moments);
	int cancelDeleteById(@Param("id")String id);
	List<Moments> searchByTitle(@Param("title")String title);
}
