package com.framework.rbac.type.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framework.base.pager.Pager;
import com.framework.rbac.type.model.Type;
import com.framework.rbac.type.service.impl.TypeServiceImpl;
import com.framework.rbac.type.service.inte.TypeService;

@Controller
@RequestMapping("/sys/type")
public class TypeController {

	@Autowired
	TypeService ts = new TypeServiceImpl();
	
	@RequestMapping("/query")
	public String query(Pager pager,Type type,Model model){
		try{
		model.addAttribute("pager", this.ts.Query(pager, type));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/TypeTable";
	}
	
	@RequestMapping("/queryOne")
	public String queryOne(Integer id,Model model){
		try{
		model.addAttribute("type", this.ts.queryOne(id));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/Type";
	}
	
	@RequestMapping("/typeAdd")
	public String typeAdd(Type type,Model model){
		try{
			this.ts.typeAdd(type.getTypeName(),type.getStatus());
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "redirect:../type/query";
	}
	
	@RequestMapping("/typeUpdate")
	public String typeUpdate(Type type,Model model){
		try{
		this.ts.informationUpdate(type.getId(), type.getTypeName(),type.getStatus());
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "redirect:../type/query";
	}
	@RequestMapping("/typeDelete")
	public String typeDelete(Integer id,Model model){
		try{
			this.ts.informationDelete(id);
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "redirect:../type/query";
	}
	
}
