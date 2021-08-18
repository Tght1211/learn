package com.tght.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpServer;


public abstract class HttpFilter implements Filter {
	
	private FilterConfig filterConfig;

    public HttpFilter() {
        
    }


	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		doFilter(req, res, chain);
		
//		chain.doFilter(request, response);
	}

	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)throws IOException, ServletException ;
	
	public void init(FilterConfig fConfig) throws ServletException {
		
		this.filterConfig = fConfig;
	}


	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

}
