package com.framework.rbac.rent.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.framework.rbac.rent.model.Rent;

public interface RentDao {

	public List<Rent> Query(Map<String,Object> map);
	
	public List<Rent> QueryNull(Map<String,Object> map);
	
	public Integer queryCount();
	
	public Rent QueryOne(@Param("id")Integer id);
	
	public void rentAdd(@Param("bookName")String bookName,@Param("bookNumber")Integer bookNumber,@Param("customName")String customName,@Param("rentTime")String rentTime,@Param("returnTime")String returnTime,@Param("limitTime")String limitTime,@Param("bookId")Integer bookId);
	
	public void informationUpdate(@Param("id")Integer id,@Param("bookName")String bookName,@Param("bookNumber")Integer bookNumber,@Param("customName")String customName,@Param("rentTime")String rentTime,@Param("returnTime")String returnTime,@Param("limitTime")String limitTime,@Param("bookId")Integer bookId);
	
	public void informationDelete(@Param("id")Integer id);
	
}
