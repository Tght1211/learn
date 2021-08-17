package com.tght.servlet;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import com.oracle.jrockit.jfr.RequestDelegate;
import com.tght.bean.Book;
import com.tght.bean.Cart;
import com.tght.service.BookService;
import com.tght.service.Impl.BookServiceImpl;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private BookService bookService = new BookServiceImpl();

	protected void addBookToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 取值bookID
		String bookId = request.getParameter("bookId");
		// 通过bookID获取Book（BookService）
		Book book = bookService.getBookById(bookId);

		// 调用Cart中的add T哦Cart（）
		// Cart存放session域中
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			// 存放Session域中
			session.setAttribute("cart", cart);
		}
		cart.addBookToCart(book);
		
		//验证库存
		Integer stock = book.getStock();
		int count = cart.getMap().get(book.getId()+" ").getCount();
		if (count > stock) {
			//库存不足
			session.setAttribute("msg", "库存不足，只剩"+stock+"件商品！");
			//将购买商品的数量，设置为最大库存。
			cart.getMap().get(book.getId()+" ").setCount(stock);
		}else {
			// 将titile存放到session域中
			session.setAttribute("title", book.getTitle());
		}
		
		
		// 获取Referer：跳转
		String url = request.getHeader("Referer");
		// 跳转
		// request.getRequestDispatcher(url).forward(request,response);
		// 不能用转发，转发是服务器解析，自己到项目名为起点
		response.sendRedirect(url);
		// response.sendRedirect(request.getContextPath() + "/index.jsp");

	}

	/**
	 * 删除购物项
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	protected void delCartItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 取bookid值
		String bookId = request.getParameter("bookId");
		// 调用Cart
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart != null) {
			cart.delCartItem(bookId);
		}

		response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
	}

	/**
	 * 清空购物车
	 */

	protected void emptyCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 调用Cart
		Cart cart = (Cart) session.getAttribute("cart");

		if(cart != null) {
			cart.emptyCart();
		}
		//跳转（1.首页2.购物车）
		response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
	}


	protected void updateCartItemCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//取值bookId，count
		String bookId = request.getParameter("bookId");
		String count = request.getParameter("count");
		//调用cart
		Cart cart = (Cart)session.getAttribute("cart");
		if (cart != null) {
			cart.updateCartItemCount(bookId, count);
		}
		//跳转
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
	}
}
