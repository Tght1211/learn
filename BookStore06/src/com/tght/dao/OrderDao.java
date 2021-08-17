package com.tght.dao;

import com.tght.bean.Order;;

public interface OrderDao {

	/**
	 * 添加Order
	 * sql:
	 * @param order
	 */
	void insertOrder(Order order);
	
	
}
