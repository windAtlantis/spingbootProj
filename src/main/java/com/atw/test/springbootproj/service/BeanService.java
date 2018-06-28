package com.atw.test.springbootproj.service;

/**
 * @author Karl
 * @Description
 * @date 2018/6/28 22:51
 */
//@Component
public class BeanService {

	public BeanService() {
		System.out.println("BeanService init");
	}

	public void say() {
		System.out.println("BeanService say hello");
	}
}
