package cn.lijiahao.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lijiahao.demo.dao.CategoryDao;
import cn.lijiahao.demo.po.Category;
import cn.lijiahao.demo.service.CategoryService;
@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;
	
	public Category selectByid(String id) {
		// TODO Auto-generated method stub
		return categoryDao.selectByid(id);
	}

	public Category selectByCategoryName(String name) {
		// TODO Auto-generated method stub
		return categoryDao.selectByCategoryName(name);
	}

	public List<Category> selectAll() {
		// TODO Auto-generated method stub
		return categoryDao.selectAll();
	}

	public List<Category> selectAllOrderPag(int begin, int size) {
		// TODO Auto-generated method stub
		return categoryDao.selectAllOrderPag(begin, size);
	}

	public int selectCountOfRows() {
		// TODO Auto-generated method stub
		return categoryDao.selectCountOfRows();
	}

	public int add(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.add(category);
	}

	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return categoryDao.deleteById(id);
	}

	public int update(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.update(category);
	}

}
