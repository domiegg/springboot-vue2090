package com.framework.rbac.day.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.framework.rbac.day.model.Day;

public interface DayDao {

	public List<Day> Query(Map<String,Object> map);
	
	public Integer queryCount();
	
	public void dayAdd(@Param("adminName")String adminName,@Param("time")String time);
	
	public void informationUpdate(@Param("id")Integer id,@Param("adminName")String adminName,@Param("time")String time);
	
	public void informationDelete(@Param("id")Integer id);
	
}
