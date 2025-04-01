package com.framework.rbac.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framework.base.pager.Pager;
import com.framework.rbac.user.model.User;
import com.framework.rbac.user.service.impl.UserServiceImpl;
import com.framework.rbac.user.service.inte.UserService;

@Controller
@RequestMapping("/sys")
public class UserController {

	@Autowired
	UserService usi = new UserServiceImpl();
	@RequestMapping("/login")
	public String login(String account,String password,Model model,HttpServletRequest request){
		try{
			User user = this.usi.login(account, password,null);
			HttpSession session = request.getSession();
			session.setAttribute("User", user);
			return "redirect:../sys/request/index";
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			return "redirect:../sys/request/login";
		}
	}
	
	@RequestMapping("/loginAdmin")
	public String loginAdmin(String account,String password,String type,Model model,HttpServletRequest request){
		try{
			User user = this.usi.login(account, password,"2");
			HttpSession session = request.getSession();
			session.setAttribute("Admin", user);
			return "redirect:../sys/request/background/index";
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			return "redirect:../sys/request/background/index";
		}
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
			session.removeAttribute("User");
			return "redirect:../sys/request/login";
	}
	@RequestMapping("/logoutAdmin")
	public String logoutAdmin(HttpSession session){
			session.removeAttribute("Admin");
			return "redirect:../sys/request/background/index";
	}
	@RequestMapping("/query")
	public String query(Pager pager,User user,Model model){
		String href = "";
		try{
			model.addAttribute("pager", this.usi.Query(pager, user));
			if(user.getType().equals("3")){
				href = "jsp/TeacherTable";
			}else{
				href = "jsp/UserTable";
			}
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return href;
	}
	@RequestMapping("/queryOne")
	public String queryOne(Integer id,Model model){
		try{
			User user = this.usi.queryOne(id);
			String href = "";
			if(user.getType().equals("3")){
				href = "jsp/Teacher";
			}else{
				href = "jsp/User";
			}
			model.addAttribute("user", user);
			return href;
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			return "redirect:../sys/query";
		}
	}
	@RequestMapping("/queryOneB")
	public String queryOneB(Integer id,Model model){
		try{
			User user = this.usi.queryOne(id);
			model.addAttribute("user", user);
			return "jsp/background/User";
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			return "redirect:../sys/queryB";
		}
	}
	
	@RequestMapping("/userAdd")
	public String userAdd(User user,Model model){
		try{
			this.usi.userAdd(user.getAccount(), user.getTel(), user.getAddress(), user.getPassword(), user.getType(),user.getEmail());
			model.addAttribute("type", user.getType());
			return "redirect:../sys/query";
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			return "redirect:../sys/query";
		}
	}
	
	@RequestMapping("/userUpdate")
	public String userUpdate(User user,Model model){
			this.usi.informationUpdate(user.getId(),user.getAccount(), user.getTel(), user.getAddress(), user.getPassword(), user.getType(),user.getEmail());
			return "redirect:../sys/request/main";
	}
	@RequestMapping("/delete")
	public String delete(Integer id){
			this.usi.informationDelete(id);
			return "redirect:../sys/request/main";
	}
	
	
}
