package com.atw.test.springbootproj.config;

import com.atw.test.springbootproj.interceptor.impl.LoginHandlerInterceptor;
import com.atw.test.springbootproj.service.BeanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
		registry.addViewController("/index.html").setViewName("login");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/main").setViewName("main");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginHandlerInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/", "/index.html", "/error",
						"/login", "/user/login",
						// spring boot 2.x依赖的spring 5.x版本，相对于spring boot 1.5.x依赖的spring 4.3.x版本而言，针对资源的拦截器初始化时有区别
						// 从源码当中可以看出，使用spring 5.x时，静态资源也会执行自定义的拦截器，因此在配置拦截器的时候需要指定排除静态资源的访问路径
						"/webjars/**", "/assets/**");
	}
}
