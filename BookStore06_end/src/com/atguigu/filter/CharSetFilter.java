package com.atguigu.filter;



/**
 * Servlet Filter implementation class CharSetFilter
 */
public class CharSetFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String code = this.getFilterConfig().getInitParameter("code");
		request.setCharacterEncoding(code);
		response.setContentType("text/html;charset=UTF-8");
		//放行
		chain.doFilter(request, response);
	}
       

}
