package com.framework.rbac.rent.service.inte;


import com.framework.base.pager.Pager;
import com.framework.rbac.rent.model.Rent;

public interface RentService {

	public Pager Query(Pager pager,String customName);
	
	public Pager QueryNull(Pager pager,String customName);
	
	public Integer queryCount();
	
	public Rent QueryOne(Integer id);
	
	public void rentAdd(String bookName,Integer bookNumber,String customName,String rentTime,String returnTime,String limitTime,Integer bookId);
	
	public void informationUpdate(Integer id,String bookName,Integer bookNumber,String customName,String rentTime,String returnTime,String limitTime,Integer bookId);
	
	public void informationDelete(Integer id);	
	
}
