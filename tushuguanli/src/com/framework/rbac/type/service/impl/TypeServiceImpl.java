package com.framework.rbac.type.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.pager.Pager;
import com.framework.rbac.type.dao.TypeDao;
import com.framework.rbac.type.model.Type;
import com.framework.rbac.type.service.inte.TypeService;
@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeDao typeDao;
	@Override
	public Pager Query(Pager pager, Type type) {
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("type", type);
		List<Type> list = this.typeDao.Query(map);
		if(list==null||list.isEmpty()){
			throw new RuntimeException("暂时没有书架");
		}
		pager.setDatas(list);
		pager.setTotalCount(queryCount());
		return pager;
	}

	@Override
	public Integer queryCount() {
		Integer count = this.typeDao.queryCount();
		return count;
	}

	@Override
	public void typeAdd(String typeName,String status) {
		try{
			this.typeDao.typeAdd(typeName,status);
		}catch (Exception e) {
			throw new RuntimeException("添加失败,原因为:"+e.getMessage());
		}	
		
	}

	@Override
	public void informationUpdate(Integer id, String typeName,String status) {
		try{
			this.typeDao.informationUpdate(id, typeName,status);
		}catch (Exception e) {
			throw new RuntimeException("修改失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public void informationDelete(Integer id) {
		try{
			this.typeDao.informationDelete(id);
		}catch (Exception e) {
			throw new RuntimeException("删除失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public Type queryOne(Integer id) {
		Type type = this.typeDao.queryOne(id);
		return type;
		
	}

	@Override
	public List<Type> QueryAll(String status) {
		try{
		List<Type> list = this.typeDao.QueryAll(status);
		return list;
		}catch (Exception e) {
			throw new RuntimeException("暂时没有类别");
		}
	}

	
	
}
