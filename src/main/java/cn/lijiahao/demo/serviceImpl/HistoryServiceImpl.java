package cn.lijiahao.demo.serviceImpl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lijiahao.demo.dao.HistoryDao;
import cn.lijiahao.demo.po.History;
import cn.lijiahao.demo.service.HistoryService;
@Service("HistoryService")
public class HistoryServiceImpl implements HistoryService{

	@Autowired
	private HistoryDao historyDao;

	public List<History> selectAll(String id) {
		// TODO Auto-generated method stub
		return historyDao.selectAll();
	}

	public List<History> selectAllOrderPag(int begin, int size, String id) {
		// TODO Auto-generated method stub
		return historyDao.selectAllOrderPag(begin, size);
	}

	public int selectCountOfRows(String id) {
		// TODO Auto-generated method stub
		return historyDao.selectCountOfRows(id);
	}

	public int add(History history) {
		// TODO Auto-generated method stub
		return historyDao.add(history);
	}

	public History selectHistoryBysys_midAndsys_uid(String sys_mid, String sys_uid) {
		// TODO Auto-generated method stub
		return historyDao.selectHistoryBysys_midAndsys_uid(sys_mid, sys_uid);
	}

	public int update(History history) {
		// TODO Auto-generated method stub
		return historyDao.update(history);
	}

	public List<String> selectBysys_uid(String sys_uid) {
		// TODO Auto-generated method stub
		return historyDao.selectBysys_uid(sys_uid);
	}
	

	

}
