package com.framework.rbac.rent.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framework.base.pager.Pager;
import com.framework.rbac.book.model.Book;
import com.framework.rbac.book.service.impl.BookServiceImpl;
import com.framework.rbac.book.service.inte.BookService;
import com.framework.rbac.rent.model.Rent;
import com.framework.rbac.rent.service.impl.RentServiceImpl;
import com.framework.rbac.rent.service.inte.RentService;

@Controller
@RequestMapping("/sys/rent")
public class RentController {

	@Autowired
	RentService rs = new RentServiceImpl();
	@Autowired
	BookService bs = new BookServiceImpl();
	
	@RequestMapping("/query")
	public String query(Pager pager,String customName,Model model){
		try{
		model.addAttribute("pager", this.rs.Query(pager,customName));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/RentRecord";
	}
	
	@RequestMapping("/queryNull")
	public String queryNull(Pager pager,String customName,Model model){
		try{
		model.addAttribute("pager", this.rs.QueryNull(pager,customName));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/RentTable";
	}
	
	@RequestMapping("/queryOne")
	public String queryOne(Integer id,Model model){
		try{
		model.addAttribute("rent", this.rs.QueryOne(id));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/Rent";
	}
	
	@RequestMapping("/add")
	public String add(Rent rent,Model model,HttpSession session){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		String rentTime = dateFormat.format(date);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 30);//计算30天后的时间
		String limitTime=dateFormat.format(c.getTime());
			Book book = this.bs.queryOne(rent.getBookId());
			this.bs.informationUpdate(book.getId(), null, null, book.getBookNumber()-1, null, null, null);
			this.rs.rentAdd(rent.getBookName(), rent.getBookNumber(), rent.getCustomName(), rentTime, null, limitTime,rent.getBookId());
		return "redirect:../request/main";
	}
	
	@RequestMapping("/update")
	public String update(Rent rent,Model model,HttpSession session){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		String returnTime = dateFormat.format(date);
		Rent r = this.rs.QueryOne(rent.getId());
		Book book = this.bs.queryOne(r.getBookId());
		this.bs.informationUpdate(book.getId(), null, null, book.getBookNumber()+1, null, null, null);
			this.rs.informationUpdate(rent.getId(), null, null, null, null, returnTime, null,rent.getBookId());
		return "redirect:../request/main";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id,Model model){
			this.rs.informationDelete(id);
			
		return "redirect:query";
	}
}
