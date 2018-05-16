package com.github.johnsonmoon.fastboot.example.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by johnsonmoon at 2018/5/16 16:15.
 */
public class TestFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String url = httpServletRequest.getRequestURL().toString();
		if (url.contains("test")) {
			httpServletResponse.getOutputStream().write("Hello! Johnson!".getBytes());
			httpServletResponse.getOutputStream().flush();
		}
	}

	@Override
	public void destroy() {

	}
}
