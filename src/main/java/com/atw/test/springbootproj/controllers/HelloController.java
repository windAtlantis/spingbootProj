package com.atw.test.springbootproj.controllers;

import com.atw.test.springbootproj.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Karl
 * @Description
 * @date 2018/6/11 22:24
 */
@RestController
public class HelloController {

	@Value("${tempvar}")
	private String tempvar;

	@Autowired
	private Person person;

	@RequestMapping("/hello")
	public String hello() {
		return "hello "+tempvar;
	}

	@RequestMapping("/person")
	public String person() {
		return person.toString();
	}
}
