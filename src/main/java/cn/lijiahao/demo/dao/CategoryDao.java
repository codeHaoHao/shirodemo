package cn.lijiahao.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lijiahao.demo.po.Category;

public interface CategoryDao {
	Category selectByid(@Param("id")String id);
	Category selectByCategoryName(@Param("name")String name);
	List<Category> selectAll();
	List<Category> selectAllOrderPag(@Param("begin")int begin,@Param("size")int size);
	int selectCountOfRows();
	int add(Category category);
	int deleteById(@Param("id")String id);
	int update(Category category);
}
