package com.tght.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable{
	private Book book;//图书信息
	private int count; //图书数量
	private double amount; //购物项中图书的金额，通过计算得到 
	
	public CartItem() {
		super();
	}
	public CartItem(Book book, int count, double amount) {
		super();
		this.book = book;
		this.count = count;
		this.amount = amount;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * 计算购物项金额
	 * 控制精度
	 * @return
	 */
	public double getAmount() {
		BigDecimal price = new BigDecimal(book.getPrice()+"");
		BigDecimal c = new BigDecimal(count+"");
		return price.multiply(c).doubleValue();
		//return book.getPrice()*count;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + ", amount=" + amount + "]";
	}
	
	
}
