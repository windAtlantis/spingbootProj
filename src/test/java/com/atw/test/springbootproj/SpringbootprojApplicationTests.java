package com.atw.test.springbootproj;

import com.atw.test.springbootproj.entity.Other;
import com.atw.test.springbootproj.service.BeanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 导入xml配置文件
 */
//@ImportResource
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootprojApplicationTests {

	@Autowired
	private Other other;

	@Autowired
	private BeanService beanService;

	@Autowired
	private ApplicationContext aoc;

	@Test
	public void contextLoads() {
		System.out.println(other.toString());
	}

	@Test
	public void testBean() {
		System.out.println(aoc.containsBean("beanService"));
		beanService.say();
	}
}
