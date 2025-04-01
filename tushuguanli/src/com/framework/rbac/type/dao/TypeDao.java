package com.framework.rbac.type.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.framework.rbac.type.model.Type;

public interface TypeDao {

	public List<Type> Query(Map<String,Object> map);
	
	public List<Type> QueryAll(@Param("status")String status);
	
	public Integer queryCount();
	
	public Type queryOne(@Param("id")Integer id);
	
	public void typeAdd(@Param("typeName")String typeName,@Param("status")String status);
	
	public void informationUpdate(@Param("id")Integer id,@Param("typeName")String typeName,@Param("status")String status);
	
	public void informationDelete(@Param("id")Integer id);
	
}
