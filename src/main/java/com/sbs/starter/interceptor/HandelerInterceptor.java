package com.sbs.starter.interceptor;

import javax.servlet.http.HttpServletRequest;

public interface HandelerInterceptor {

	boolean preHandle();

	public boolean preHandle(HttpServletRequest request, HttpSevletResponse response, Object handler);

}
