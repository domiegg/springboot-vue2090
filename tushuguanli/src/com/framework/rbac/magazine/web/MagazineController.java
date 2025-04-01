package com.framework.rbac.magazine.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framework.base.pager.Pager;
import com.framework.rbac.magazine.model.Magazine;
import com.framework.rbac.magazine.service.impl.MagazineServiceImpl;
import com.framework.rbac.magazine.service.inte.MagazineService;
import com.framework.rbac.type.service.impl.TypeServiceImpl;
import com.framework.rbac.type.service.inte.TypeService;

@Controller
@RequestMapping("/sys/magazine")
public class MagazineController {

	@Autowired
	MagazineService bs = new MagazineServiceImpl();
	@Autowired
	TypeService ts = new TypeServiceImpl();
	
	@RequestMapping("/query")
	public String query(Pager pager,Magazine book,String search,String searchType,Model model){
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
		return "jsp/MagazineTable";
	}
	@RequestMapping("/manage")
	public String manage(Pager pager,Magazine book,String search,String searchType,Model model){
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
		return "jsp/MagazineManage";
	}
	
	@RequestMapping("/queryOne")
	public String queryOne(Integer id,Model model){
		try{
		model.addAttribute("magazine", this.bs.queryOne(id));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/Magazine";
	}
	@RequestMapping("/add")
	public String add(Magazine book,Model model){
		this.bs.bookAdd(book.getBookName(), book.getBookType(), book.getBookNumber(), "1", book.getBookWriter(), book.getBookHouse());
		return "redirect:manage";
	}
	@RequestMapping("/update")
	public String update(Magazine book,Model model){
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
			model.addAttribute("type", this.ts.QueryAll("2"));
		model.addAttribute("magazine", this.bs.queryOne(id));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/MagazineEdit";
	}
	
}
