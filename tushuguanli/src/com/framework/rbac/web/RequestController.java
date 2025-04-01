package com.framework.rbac.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framework.rbac.type.service.impl.TypeServiceImpl;
import com.framework.rbac.type.service.inte.TypeService;


@Controller
@RequestMapping("/sys/request")
public class RequestController {

	@Autowired
	TypeService ts = new TypeServiceImpl();
	@RequestMapping("/top")
	public String center(){
		return "jsp/top";
	}
	@RequestMapping("/index")
	public String index(){
		return "jsp/index";
	}
	@RequestMapping("/add")
	public String add(){
		return "jsp/add";
	}
	@RequestMapping("/menu")
	public String down(){
		return "jsp/menu";
	}
	@RequestMapping("/main")
	public String left(){
		return "jsp/main";
	}
	@RequestMapping("/login")
	public String login(String messageLogin,Model model){
		model.addAttribute("messageLogin", messageLogin);
		return "jsp/login";
	}
	@RequestMapping("/bookAdd")
	public String bookAdd(Model model){
		model.addAttribute("type", this.ts.QueryAll("1"));
		return "jsp/BookAdd";
	}
	@RequestMapping("/magazineAdd")
	public String magazineAdd(Model model){
		model.addAttribute("type", this.ts.QueryAll("2"));
		return "jsp/MagazineAdd";
	}
	@RequestMapping("/userAdd")
	public String userAdd(){
		return "jsp/UserAdd";
	}
	@RequestMapping("/teacherAdd")
	public String teacherAdd(){
		return "jsp/TeacherAdd";
	}
	@RequestMapping("/typeAdd")
	public String typeAdd(){
		return "jsp/TypeAdd";
	}
	@RequestMapping("/outAdd")
	public String outAdd(){
		return "jsp/OutAdd";
	}
	@RequestMapping("/payAdd")
	public String payAdd(){
		return "jsp/PayAdd";
	}
	@RequestMapping("/repairAdd")
	public String repairAdd(){
		return "jsp/RepairAdd";
	}
	@RequestMapping("/alert")
	public String alert(){
		return "jsp/alert";
	}
}
