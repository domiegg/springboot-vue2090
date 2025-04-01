package com.framework.rbac.book.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.pager.Pager;
import com.framework.rbac.book.dao.BookDao;
import com.framework.rbac.book.model.Book;
import com.framework.rbac.book.service.inte.BookService;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	@Override
	public Pager Query(Pager pager, Book book) {
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("book", book);
		List<Book> list = this.bookDao.Query(map);
		if(list==null||list.isEmpty()){
			throw new RuntimeException("暂时没有书籍");
		}
		pager.setDatas(list);
		pager.setTotalCount(queryCount(book));
		return pager;
	}

	@Override
	public Integer queryCount(Book book) {
		Integer count = this.bookDao.queryCount(book);
		return count;
	}

	@Override
	public void bookAdd(String bookName, String bookType, Integer bookNumber, String bookStatus,String bookWriter,String bookHouse) {
		try{
			this.bookDao.bookAdd(bookName, bookType, bookNumber, bookStatus,bookWriter,bookHouse);
		}catch (Exception e) {
			throw new RuntimeException("添加失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public void informationUpdate(Integer id, String bookName, String bookType, Integer bookNumber, String bookStatus,String bookWriter,String bookHouse) {
		try{
			this.bookDao.informationUpdate(id, bookName, bookType, bookNumber, bookStatus,bookWriter,bookHouse);
		}catch (Exception e) {
			throw new RuntimeException("修改失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public void informationDelete(Integer id) {
		try{
			this.bookDao.informationDelete(id);
		}catch (Exception e) {
			throw new RuntimeException("删除失败,原因为:"+e.getMessage());
		}
		
	}

	@Override
	public Book queryOne(Integer id) {
		Book book = new Book();
		try{
			book = this.bookDao.QueryOne(id);
		}catch (Exception e) {
			throw new RuntimeException("并没与该书籍");
		}
		return book;
	}
	
}
