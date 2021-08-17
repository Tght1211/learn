package com.tght.service;

import java.util.List;

import com.tght.bean.Book;
import com.tght.bean.Page;

public interface BookService {
	public List<Book> getAllBooks();
	
	public void addBook(Book book);
	
	public void delBookById(String id);
	
	public Book getBookById(String id);
	public void updateBook(Book book);
	
	public Page<Book> getBooksByPage(String pageNo);
	
	public Page<Book> getBookByPageAndPrice(String pageNo,String min, String max);
}
