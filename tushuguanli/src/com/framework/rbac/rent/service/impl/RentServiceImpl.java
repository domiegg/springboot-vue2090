package com.framework.rbac.rent.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.pager.Pager;
import com.framework.rbac.rent.dao.RentDao;
import com.framework.rbac.rent.model.Rent;
import com.framework.rbac.rent.service.inte.RentService;
@Service
public class RentServiceImpl implements RentService {

	@Autowired
	private RentDao rentDao;
	@Override
	public Pager Query(Pager pager,String customName) {
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("customName", customName);
		List<Rent> list = this.rentDao.Query(map);
		if(list==null||list.isEmpty()){
			throw new RuntimeException("暂时没有记录");
		}
		pager.setDatas(list);
		pager.setTotalCount(queryCount());
		return pager;
	}
	
	@Override
	public Pager QueryNull(Pager pager,String customName) {
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("customName", customName);
		List<Rent> list = this.rentDao.QueryNull(map);
		if(list==null||list.isEmpty()){
			throw new RuntimeException("暂时没有记录");
		}
		pager.setDatas(list);
		pager.setTotalCount(queryCount());
		return pager;
	}

	@Override
	public Integer queryCount() {
		Integer count = this.rentDao.queryCount();
		return count;
	}

	@Override
	public Rent QueryOne(Integer id) {
		Rent rent = new Rent();
		try{
			rent = this.rentDao.QueryOne(id);
		}catch (Exception e) {
			throw new RuntimeException("并没与该记录");
		}
		return rent;
	}

	@Override
	public void rentAdd(String bookName, Integer bookNumber, String customName, String rentTime, String returnTime,
			String limitTime,Integer bookId) {
		try{
			this.rentDao.rentAdd(bookName, bookNumber, customName, rentTime,returnTime,limitTime,bookId);
		}catch (Exception e) {
			throw new RuntimeException("添加失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public void informationUpdate(Integer id, String bookName, Integer bookNumber, String customName, String rentTime,
			String returnTime, String limitTime,Integer bookId) {
		try{
			this.rentDao.informationUpdate(id, bookName, bookNumber, customName, rentTime,returnTime,limitTime,bookId);
		}catch (Exception e) {
			throw new RuntimeException("修改失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public void informationDelete(Integer id) {
		try{
			this.rentDao.informationDelete(id);
		}catch (Exception e) {
			throw new RuntimeException("删除失败,原因为:"+e.getMessage());
		}
		
	}

}
