package com.framework.rbac.day.service.inte;

import com.framework.base.pager.Pager;
import com.framework.rbac.day.model.Day;

public interface DayService {

	public Pager Query(Pager pager,Day day);
	
	public Integer queryCount();
	
	public void dayAdd(String adminName,String time);
	
	public void informationUpdate(Integer id,String adminName,String time);
	
	public void informationDelete(Integer id);
	
}
