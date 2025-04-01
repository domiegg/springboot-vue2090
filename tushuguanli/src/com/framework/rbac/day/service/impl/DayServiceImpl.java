package com.framework.rbac.day.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.pager.Pager;
import com.framework.rbac.day.dao.DayDao;
import com.framework.rbac.day.model.Day;
import com.framework.rbac.day.service.inte.DayService;
@Service
public class DayServiceImpl implements DayService {

	@Autowired
	private DayDao dayDao;
	
	@Override
	public Pager Query(Pager pager,Day day) {
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("day", day);
		List<Day> list = this.dayDao.Query(map);
		if(list==null||list.isEmpty()){
			throw new RuntimeException("暂时没有打卡记录");
		}
		pager.setDatas(list);
		pager.setTotalCount(queryCount());
		return pager;
	}

	@Override
	public Integer queryCount() {
		Integer count = this.dayDao.queryCount();
		return count;
	}

	@Override
	public void dayAdd(String adminName, String time) {
		try{
			this.dayDao.dayAdd(adminName,time);
		}catch (Exception e) {
			throw new RuntimeException("添加失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public void informationUpdate(Integer id, String adminName, String time) {
		try{
			this.dayDao.informationUpdate(id, adminName,time);
		}catch (Exception e) {
			throw new RuntimeException("修改失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public void informationDelete(Integer id) {
		try{
			this.dayDao.informationDelete(id);
		}catch (Exception e) {
			throw new RuntimeException("删除失败,原因为:"+e.getMessage());
		}
		
	}

}
