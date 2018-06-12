package com.atw.test.springbootproj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Karl
 * @Description
 * @date 2018/6/12 23:49
 */
@Controller
public class HelloYouController {

	@RequestMapping("/helloyou")
	public String hello() {
		return "hello";
	}
}
