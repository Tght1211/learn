package com.tght.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tght.bean.Book;
import com.tght.bean.Page;
import com.tght.service.BookService;
import com.tght.service.Impl.BookServiceImpl;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	/**
	 * 查询book信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private BookService bookService = new BookServiceImpl();

//	protected void getAllBooks(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// 取值（不用）
//		// 调用service中的相应方法
//		List<Book> books = bookService.getAllBooks();
//		// 将books存到域中
//		request.setAttribute("books", books);
//		// 跳转，book_manager.jsp
//		request.getRequestDispatcher("pages/manager/book_manager.jsp").forward(request, response);
//
//	}

	/**
	 * 添加book信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
//	protected void addBook(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// 取值
//		String title = request.getParameter("title");
//		String author = request.getParameter("author");
//		String price = request.getParameter("price");
//		String sales = request.getParameter("sales");
//		String stock = request.getParameter("stock");
//		// 调用service
//		bookService.addBook(new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales),
//				Integer.parseInt(stock), null));
//		// 跳转,重新查询,book_manager.jsp
//		// getAllBooks(request, response);
//		response.sendRedirect(request.getContextPath() + "/BookServlet?method=getAllBooks");
//	}

	protected void delBookById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取值
		String id = request.getParameter("bookId");
		// 调用service
		bookService.delBookById(id);
		// 跳转
		response.sendRedirect(request.getContextPath() + "/BookServlet?method=getBooksByPage");
	}

	protected void getBookById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取值
		String id = request.getParameter("bookId");
		// 调用service
		Book book = bookService.getBookById(id);
		// 将book存放在域中
		request.setAttribute("book", book);
		// 跳转
		request.getRequestDispatcher("pages/manager/book_update.jsp").forward(request, response);
	}

	protected void updateBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取值
		String id = request.getParameter("bookId");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String sales = request.getParameter("sales");
		String stock = request.getParameter("stock");
		if(id == null || "".equals(id)) {
			bookService.addBook(new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales),
					Integer.parseInt(stock), null));
		}else {
			bookService.updateBook(new Book(Integer.parseInt(id), title, author, Double.parseDouble(price),
					Integer.parseInt(sales), Integer.parseInt(stock), null));
		}		
		// 跳转
		response.sendRedirect(request.getContextPath() + "/BookServlet?method=getBooksByPage");
	}
	/**
	 * 分页查询
	 */
	protected void getBooksByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//取值
		String pageNo = request.getParameter("pageNo");
		//调用service
		Page<Book> page = bookService.getBooksByPage(pageNo);
		//存放域
		request.setAttribute("page", page);
		//跳转
		request.getRequestDispatcher("pages/manager/book_manager.jsp").forward(request, response);
	}
}
