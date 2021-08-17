package com.tght.dao;

import java.util.List;

import com.tght.bean.Book;
import com.tght.bean.Page;

public interface BookDao {
	/**查询所有book信息
	sql:select * from books
	*/
	public  List<Book> getAllBooks();
	/**
	 * 添加book信息
	 * sql：insert into books (title,author,price,sales,stock,img_path) values(?,?,?,?,?,?)
	 */
	public void  addBook(Book book);
	
	/**
	 * 删除book，通过bookId
	 * @param id
	 */
	public void delBookById(String id);

	/**
	 * 修改book
	 * 		1.通过id获取Book信息
	 * 		2.upadateBook
	 */
	public  Book  getBookById(String id);
	
	
	/**
	 * 修改book
	 * 	sql:update books set title=?,author=?,price=?,sales=?,stock=? where id=?
	 */
	public void updateBook(Book book);
	public void updateBook(int stock,int sales,int id);
	public void updateBook(Object[][] params);
	
	/**
	 * 实现分页查询Book
	 */
	public Page<Book> getBooksByPage(Page<Book> page);
	
	public Page<Book> getBookByPageAndPrice(Page<Book> page,Double min, Double max);
	
}








