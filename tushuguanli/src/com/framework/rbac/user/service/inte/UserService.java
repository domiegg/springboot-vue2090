package com.framework.rbac.user.service.inte;



import org.springframework.stereotype.Service;

import com.framework.base.pager.Pager;
import com.framework.rbac.user.model.User;
@Service
public interface UserService {

	public User login(String account,String password,String type);
	
	public User queryOne(Integer id);
	
	public Pager Query(Pager pager,User user);
	
	public Integer queryCount(User user);
	
	public void userAdd(String account,String tel,String address,String password,String type,String email);
	
	public void informationUpdate(Integer id,String account,String tel,String address,String password,String type,String email);
	
	public void informationDelete(Integer id);
}
