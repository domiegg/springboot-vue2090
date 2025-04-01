package com.framework.rbac.magazine.service.inte;

import com.framework.base.pager.Pager;
import com.framework.rbac.magazine.model.Magazine;

public interface MagazineService {

public Pager Query(Pager pager,Magazine book);
	
	public Integer queryCount(Magazine book);
	
	public Magazine queryOne(Integer id);
	
	public void bookAdd(String bookName,String bookType,Integer bookNumber,String bookStatus,String bookWriter,String bookHouse);
	
	public void informationUpdate(Integer id,String bookName,String bookType,Integer bookNumber,String bookStatus,String bookWriter,String bookHouse);
	
	public void informationDelete(Integer id);
	
}
