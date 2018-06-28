package com.atw.test.springbootproj.config;

import com.atw.test.springbootproj.service.BeanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Karl
 * @Description
 * @date 2018/6/28 22:43
 */
@Configuration
public class MyConfig {

	@Bean
	public BeanService beanService() {
		return new BeanService();
	}
}
