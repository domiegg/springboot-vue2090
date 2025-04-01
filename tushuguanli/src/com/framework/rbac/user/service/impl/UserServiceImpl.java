package com.framework.rbac.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.pager.Pager;
import com.framework.rbac.user.dao.UserDao;
import com.framework.rbac.user.model.User;
import com.framework.rbac.user.service.inte.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public User login(String account, String password,String type) {
			User user = userDao.login(account, password,type);
			if(user==null){
				throw new RuntimeException("用户名或密码错误!");
			}
			return user;
	}
	@Override
	public User queryOne(Integer id) {
		User user = this.userDao.queryOne(id);
		return user;
	}
	@Override
	public Pager Query(Pager pager,User user) {
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("user", user);
		List<User> list = this.userDao.Query(map);
		if(list==null||list.isEmpty()){
			throw new RuntimeException("暂时没有用户");
		}
		pager.setDatas(list);
		pager.setTotalCount(queryCount(user));
		return pager;
	}
	@Override
	public Integer queryCount(User user) {
		Integer count = this.userDao.queryCount(user);
		return count;
	}
	@Override
	public void userAdd(String account, String tel, String address, String password, String type,String email) {
		try{
			this.userDao.userAdd(account, tel, address, password,type,email);
		}catch (Exception e) {
			throw new RuntimeException("添加失败,原因为:"+e.getMessage());
		}
		
	}
	@Override
	public void informationUpdate(Integer id, String account, String tel, String address, String password,
			String type,String email) {
		try{
			this.userDao.informationUpdate(id, account, tel, address, password,type,email);
		}catch (Exception e) {
			throw new RuntimeException("修改失败,原因为:"+e.getMessage());
		}
		
	}
	@Override
	public void informationDelete(Integer id) {
		try{
			this.userDao.informationDelete(id);
		}catch (Exception e) {
			throw new RuntimeException("删除失败,原因为:"+e.getMessage());
		}
		
	}

}
