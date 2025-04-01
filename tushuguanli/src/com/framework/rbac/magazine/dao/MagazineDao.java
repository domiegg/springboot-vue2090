package com.framework.rbac.magazine.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.framework.rbac.magazine.model.Magazine;

public interface MagazineDao {

	public List<Magazine> Query(Map<String,Object> map);
	
	public Integer queryCount(@Param("book")Magazine book);
	
	public Magazine QueryOne(@Param("id")Integer id);
	
	public void bookAdd(@Param("bookName")String bookName,@Param("bookType")String bookType,@Param("bookNumber")Integer bookNumber,@Param("bookStatus")String bookStatus,@Param("bookWriter")String bookWriter,@Param("bookHouse")String bookHouse);
	
	public void informationUpdate(@Param("id")Integer id,@Param("bookName")String bookName,@Param("bookType")String bookType,@Param("bookNumber")Integer bookNumber,@Param("bookStatus")String bookStatus,@Param("bookWriter")String bookWriter,@Param("bookHouse")String bookHouse);
	
	public void informationDelete(@Param("id")Integer id);
	
}
