package com.tght.dao.impl;

import java.util.List;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.tght.bean.Book;
import com.tght.bean.Page;
import com.tght.dao.BaseDao;
import com.tght.dao.BookDao;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public List<Book> getAllBooks() {
		String sql="SELECT id,title,author,price,sales,stock,img_path FROM books";
		return this.getBeanList(sql);
	}

	@Override
	public void addBook(Book book) {
		String sql="insert into books (title,author,price,sales,stock,img_path) values(?,?,?,?,?,?)";
		this.update(sql, book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
	}

	@Override
	public void delBookById(String id) {
		String sql = "DELETE FROM books WHERE id = ? ";
		this.update(sql, id);
	}

	@Override
	public Book getBookById(String id) {
		String sql = "SELECT id,title,author,price,sales,stock,img_path FROM books WHERE id = ?";
		return this.getBean(sql, id);
	}

	@Override
	public void updateBook(Book book) {
		String sql = "UPDATE books SET title=?,author=?,price=?,sales=?,stock=? WHERE id = ?";
		this.update(sql, book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getId() );
	}

	@Override
	public Page<Book> getBooksByPage(Page<Book> page) {
		//page：pageNo PAGE_SIZE  totalPageNo
		//dao：totalRecord
		//dao：list
		
		String sql = "SELECT COUNT(*) FROM books";
		int count = Integer.parseInt(this.getSingeValue(sql)+"");// long 
		//将totalRecord赋值
		page.setTotalRecord(count);
		//dao：list
		String sql2="SELECT id,title,author,price,sales,stock,img_path"
				+ " FROM books "
				+ "WHERE 1=1"
				+ " LIMIT ?,?";
		List<Book> list = this.getBeanList(sql2, (page.getPageNo() - 1) * Page.PAGE_SIZE,Page.PAGE_SIZE);
		//将List存放在page中
		page.setList(list);
		
		return page;
	}

	@Override
	public Page<Book> getBookByPageAndPrice(Page<Book> page, Double min, Double max) {
		String sql = "SELECT COUNT(*)"
				+ "FROM books "
				+ "WHERE 1=1 "
				+ "AND price "
				+ "BETWEEN  ? AND ?";
		int count = Integer.parseInt(this.getSingeValue(sql,min,max)+"");// long 
		//将totalRecord赋值
		page.setTotalRecord(count);
		//dao：list
		String sql2="SELECT  id,title,author,price,sales,stock,img_path "
				+ "FROM books "
				+ "WHERE 1=1 "
				+ "AND price "
				+ "BETWEEN  ? AND ? "
				+ " LIMIT ?,?";
		List<Book> list = this.getBeanList(sql2, min,max,(page.getPageNo() - 1) * Page.PAGE_SIZE,Page.PAGE_SIZE);
		//将List存放在page中
		page.setList(list);
		
		return page;
	}

}
