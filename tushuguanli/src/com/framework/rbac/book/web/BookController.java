package com.framework.rbac.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framework.base.pager.Pager;
import com.framework.rbac.book.model.Book;
import com.framework.rbac.book.service.impl.BookServiceImpl;
import com.framework.rbac.book.service.inte.BookService;
import com.framework.rbac.type.service.impl.TypeServiceImpl;
import com.framework.rbac.type.service.inte.TypeService;

@Controller
@RequestMapping("/sys/book")
public class BookController {

	@Autowired
	BookService bs = new BookServiceImpl();
	@Autowired
	TypeService ts = new TypeServiceImpl();
	
	@RequestMapping("/query")
	public String query(Pager pager,Book book,String search,String searchType,Model model){
		if(searchType!=null&&!search.isEmpty()){
			if(searchType.equals("书籍名称")){
				book.setBookName(search);
			}else if(searchType.equals("书籍编号")){
				book.setBookNumber(Integer.parseInt(search));
			}else if(searchType.equals("书籍类型")){
				book.setBookType(search);
			}else if(searchType.equals("出版社")){
				book.setBookHouse(search);
			}else if(searchType.equals("作者")){
				book.setBookWriter(search);
			}
		}
		try{
		model.addAttribute("pager", this.bs.Query(pager, book));
		model.addAttribute("search", search);
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/BookTable";
	}
	@RequestMapping("/manage")
	public String manage(Pager pager,Book book,String search,String searchType,Model model){
		if(searchType!=null&&!search.isEmpty()){
			if(searchType.equals("书籍名称")){
				book.setBookName(search);
			}else if(searchType.equals("书籍编号")){
				book.setBookNumber(Integer.parseInt(search));
			}else if(searchType.equals("书籍类型")){
				book.setBookType(search);
			}else if(searchType.equals("出版社")){
				book.setBookHouse(search);
			}else if(searchType.equals("作者")){
				book.setBookWriter(search);
			}
		}
		try{
		model.addAttribute("pager", this.bs.Query(pager, book));
		model.addAttribute("search", search);
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/BookManage";
	}
	
	@RequestMapping("/queryOne")
	public String queryOne(Integer id,Model model){
		try{
		model.addAttribute("book", this.bs.queryOne(id));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/Book";
	}
	@RequestMapping("/add")
	public String add(Book book,Model model){
		this.bs.bookAdd(book.getBookName(), book.getBookType(), book.getBookNumber(), "1", book.getBookWriter(), book.getBookHouse());
		return "redirect:manage";
	}
	@RequestMapping("/update")
	public String update(Book book,Model model){
		this.bs.informationUpdate(book.getId(), book.getBookName(), book.getBookType(), book.getBookNumber(), book.getBookStatus(), book.getBookWriter(), book.getBookHouse());
		return "redirect:manage";
	}
	@RequestMapping("/delete")
	public String delete(Integer id,Model model){
			this.bs.informationDelete(id);
		return "redirect:manage";
	}
	@RequestMapping("/Edit")
	public String Edit(Integer id,Model model){
		try{
			model.addAttribute("type", this.ts.QueryAll("1"));
		model.addAttribute("book", this.bs.queryOne(id));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/BookEdit";
	}
	
}
