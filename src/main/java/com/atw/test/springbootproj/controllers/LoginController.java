package com.atw.test.springbootproj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author Karl
 * @Description
 * @date 2018/8/2 22:00
 */
@Controller
public class LoginController {

	@PostMapping("/user/login")
	public String userlogin(@RequestParam("form-username") String username,
	                        @RequestParam("form-password") String passwd,
	                        RedirectAttributes redirectAttributes, HttpSession session) {
		if ("admin".equals(username) && "admin".equals(passwd)) {
			session.setAttribute("loginid", username);
			return "redirect:/hello";
		} else {
			// 可以在 login 对应的模版中通过表达式，比如 jsp 中 jstl 用 ${param}，获取返回值。该值其实是保存在 session 中的，并且会在下次重定向请求时删除。
			redirectAttributes.addFlashAttribute("msg", "登陆失败");
			return "redirect:/login";
		}
	}
}
