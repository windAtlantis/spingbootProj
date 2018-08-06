package com.atw.test.springbootproj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

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
	                        Map<String, Object> map, HttpSession session) {
		if ("admin".equals(username) && "admin".equals(passwd)) {
			session.setAttribute("loginid", username);
			return "redirect:/hello";
		} else {
			map.put("msg", "登陆失败");
			return "login";
		}
	}
}
