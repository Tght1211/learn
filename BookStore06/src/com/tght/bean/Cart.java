package com.tght.bean;

import static org.hamcrest.CoreMatchers.endsWith;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart implements Serializable{
	
	// 购物项集合，总数量，总金额
	// key: bookId,value:CartItem
	private Map<String, CartItem> map = new LinkedHashMap<>();
	// 总数量
	private int totalCount;
	// 总金额
	private double totalAmount;

	/**
	 * 1.加入购物车 2.删除购物项 3.清空购物车 4.修改购物项的数量 5.获取所有的CartItem
	 */
	/**
	 * 1.加入购物车
	 * 		本质：将book添加到map中
	 * 		思路：判断购物车中是否买过该book
	 * 				买过：购买数量不+1
	 * 				没买过：
	 * 						1.new CartItem()
	 * 						2.setCount()&setBook()
	 * 						3.map.put(cartItem);
	 */
	
	public void addBookToCart(Book book) {
		//通过bookId获取CartItem,
		 CartItem cartItem = map.get(book.getId()+" ");
		 //判断购物车后中是否买过该book
		if(cartItem == null) {
			//没买过
			cartItem = new CartItem();
			cartItem.setBook(book);
			cartItem.setCount(1);
			map.put(book.getId()+" ", cartItem);
			
		}else {
			//买过
			int nCount = cartItem.getCount()+1;
			cartItem.setCount(nCount);
		}
	}
	
	/**
	 * 2.删除购物项
	 */
	
	public void delCartItem(String bookId) {
		map.remove(bookId+" ");
	}
	
	/**
	 * 3.清空购物车
	 */
	
	public void emptyCart() {
		map.clear();
	}
	
	/**
	 * 4.修改购物数量
	 */
	public void updateCartItemCount(String bookId,String count) {
		//通过bookId查找指定的CartItem
		CartItem cartItem = map.get(bookId+" ");
		//更改购物项的数量
		try {
			cartItem.setCount(Integer.parseInt(count));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}	
	}
	

	/**
	 * 5.获取所有的CartItem
	 */
	public List<CartItem> getCartItems() {
		return new ArrayList<>(map.values());
	}

	public Cart() {
		super();
	}

	public Cart(Map<String, CartItem> map, int totalCount, double totalAmount) {
		super();
		this.map = map;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
	}

	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}

	/**
	 * 计算购物车总数量
	 * 
	 * @return
	 */
	public int getTotalCount() {
		int totalCount = 0;
		for (CartItem cartItem : getCartItems()) {
			totalCount += cartItem.getCount();
		}
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 计算购物车总金额
	 * @return
	 */
	public double getTotalAmount() {
		BigDecimal tAmount = new BigDecimal("0");
		
		//double totAmount = 0;
				for (CartItem CartItem:getCartItems()) {
					BigDecimal amount  = new BigDecimal(CartItem.getAmount()+"");
//					totalAmount += CartItem.getAmount();
					tAmount = tAmount.add(amount);
				}
		return tAmount.doubleValue();
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Cart [map=" + map + ", totalCount=" + totalCount + ", totalAmount=" + totalAmount + "]";
	}

}
