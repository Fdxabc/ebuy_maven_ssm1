package com.lcvc.ebuy_maven_ssm.web.backstage;import com.lcvc.ebuy_maven_ssm.dao.AdminDao;import com.lcvc.ebuy_maven_ssm.model.Admin;import com.lcvc.ebuy_maven_ssm.service.AdminService;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpSession;@Controllerpublic class LoginLogoutController {//AdminDao adminDao=new AdminDao();	private AdminService adminService=new AdminService();	@RequestMapping(value = "/backstage/login", method = RequestMethod.POST)	public String login(String username, String password, HttpSession session) {		Admin admin=adminService.login(username,password);		if (admin!=null){			session.setAttribute("admin",admin);			return "redirect:/backstage/index";		}else {			return "/jsp/backstage/login.jsp";		}	}	@RequestMapping(value = "/backstage/index")	public String index(){		return "/jsp/backstage/main.jsp";	}}