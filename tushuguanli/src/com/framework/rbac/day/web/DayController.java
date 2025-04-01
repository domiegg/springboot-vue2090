package com.framework.rbac.day.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framework.base.pager.Pager;
import com.framework.rbac.day.model.Day;
import com.framework.rbac.day.service.impl.DayServiceImpl;
import com.framework.rbac.day.service.inte.DayService;

@Controller
@RequestMapping("/sys/day")
public class DayController {

	@Autowired
	private DayService ds = new DayServiceImpl();
	@RequestMapping("/query")
	public String query(Pager pager,Model model,Day day){
		try{
			model.addAttribute("pager", this.ds.Query(pager,day));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/DayTable";
	}
	@SuppressWarnings("null")
	@RequestMapping("/dayAdd")
	public String dayAdd(Pager pager,Day day,Model model){
		try{
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
			String time = dateFormat.format(date);
			day.setTime(time);
			@SuppressWarnings("unchecked")
			List<Day> list = (List<Day>) this.ds.Query(pager,day).getDatas();
			if(list!=null||list.size()>0){
				return "jsp/Dayfalse";
			}
			
		}catch (RuntimeException e) {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
			String time = dateFormat.format(date);
			day.setTime(time);
			this.ds.dayAdd(day.getAdminName(),time);
		}
		return "jsp/Daytrue";
	}
	
}
