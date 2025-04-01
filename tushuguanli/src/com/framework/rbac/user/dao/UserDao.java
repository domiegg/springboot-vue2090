package com.framework.rbac.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.framework.rbac.user.model.User;
public interface UserDao {
	
	public User login(@Param("account")String account,@Param("password")String password,@Param("type")String type);
	
	public User queryOne(@Param("id")Integer id);
	
	public List<User> Query(Map<String,Object> map);
	
	public Integer queryCount(@Param("user")User user);
	
	public void userAdd(@Param("account")String account,@Param("tel")String tel,@Param("address")String address,@Param("password")String password,@Param("type")String type,@Param("email")String email);
	
	public void informationUpdate(@Param("id")Integer id,@Param("account")String account,@Param("tel")String tel,@Param("address")String address,@Param("password")String password,@Param("type")String type,@Param("email")String email);
	
	public void informationDelete(@Param("id")Integer id);

}
