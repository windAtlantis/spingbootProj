package com.atw.test.springbootproj.interceptor.impl;

import com.atw.test.springbootproj.interceptor.IInterceptor;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Karl
 * @Description
 * @date 2018/7/11 22:05
 */
public class LoginHandlerInterceptor implements IInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object oauth = request.getSession().getAttribute("loginid");
		System.out.println("url is : "+request.getRequestURI());
		if (!StringUtils.isEmpty(oauth)) {
			return true;
		}

		request.setAttribute("msg", "请先登录");
		request.getRequestDispatcher("/index.html").forward(request, response);

		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
