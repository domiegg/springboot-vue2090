package com.framework.rbac.book.service.inte;

import com.framework.base.pager.Pager;
import com.framework.rbac.book.model.Book;

public interface BookService {

public Pager Query(Pager pager,Book book);
	
	public Integer queryCount(Book book);
	
	public Book queryOne(Integer id);
	
	public void bookAdd(String bookName,String bookType,Integer bookNumber,String bookStatus,String bookWriter,String bookHouse);
	
	public void informationUpdate(Integer id,String bookName,String bookType,Integer bookNumber,String bookStatus,String bookWriter,String bookHouse);
	
	public void informationDelete(Integer id);
	
}
