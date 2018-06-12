//package com.atw.test.springbootproj.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import java.nio.charset.Charset;
//import java.util.List;
//
///**
// * @author Karl
// * @Description
// * @date 2018/6/12 23:32
// */
//@Configuration
//public class WebConfiguration extends WebMvcConfigurerAdapter {
//
//	@Bean
//	public HttpMessageConverter<String> responseBodyConverter() {
//		return new StringHttpMessageConverter(Charset.forName("UTF-8"));
//	}
//
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		super.configureMessageConverters(converters);
//		converters.add(responseBodyConverter());
//	}
//
//	@Override
//	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//		configurer.favorPathExtension(false);
//	}
//}
