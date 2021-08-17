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
import javax.servlet.http.HttpSession;

import com.tght.bean.User;

/**
 * Servlet Filter implementation class CheckLoginFilter
 */
public class CheckLoginFilter extends HttpFilter {
	//留下一个doFilter， 新建完Filter后立即去Web.xml改一下触发的地方，（url-patten）
		@Override
		public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			//判断是否登录，登录：放行。未登录，跳转login.jsp
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			if(user == null) {
				//未登录，跳转login.jsp
				request.setAttribute("msg", "亲，该操作需要先登录哦！");
				request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			}else {
				//登录：放行。
				chain.doFilter(request, response);
				System.out.println("验证成功，去下一个过滤器");
			}
			
		}
	   
}
