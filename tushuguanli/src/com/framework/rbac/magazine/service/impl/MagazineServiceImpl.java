package com.framework.rbac.magazine.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.base.pager.Pager;
import com.framework.rbac.magazine.dao.MagazineDao;
import com.framework.rbac.magazine.model.Magazine;
import com.framework.rbac.magazine.service.inte.MagazineService;
@Service
public class MagazineServiceImpl implements MagazineService {

	@Autowired
	private MagazineDao bookDao;
	@Override
	public Pager Query(Pager pager, Magazine book) {
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("book", book);
		List<Magazine> list = this.bookDao.Query(map);
		if(list==null||list.isEmpty()){
			throw new RuntimeException("暂时没有期刊");
		}
		pager.setDatas(list);
		pager.setTotalCount(queryCount(book));
		return pager;
	}

	@Override
	public Integer queryCount(Magazine book) {
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
	public Magazine queryOne(Integer id) {
		Magazine book = new Magazine();
		try{
			book = this.bookDao.QueryOne(id);
		}catch (Exception e) {
			throw new RuntimeException("并没与该期刊");
		}
		return book;
	}
	
}
