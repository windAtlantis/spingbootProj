package com.atw.test.springbootproj.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Karl
 * @Description
 * @date 2018/6/11 22:24
 */
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello world!";
	}
}
