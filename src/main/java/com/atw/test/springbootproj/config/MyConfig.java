package com.atw.test.springbootproj.config;

import com.atw.test.springbootproj.service.BeanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Karl
 * @Description
 * @date 2018/6/28 22:43
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

	@Bean
	public BeanService beanService() {
		return new BeanService();
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
	}
}
