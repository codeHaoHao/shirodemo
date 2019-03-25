package cn.lijiahao.demo.serviceWithRedis;

import java.util.List;


import cn.lijiahao.demo.po.Category;

public interface CategoryService {
	Category selectByid(String id);
	Category selectByCategoryName(String name);
	List<Category> selectAll();
	List<Category> selectAllOrderPag(int begin,int size);
	int selectCountOfRows();
	int add(Category category);
	int deleteById(String id);
	int update(Category category);
}
