package com.tght.dao;

import com.tght.bean.OrderItem;

public interface OrderItemDao {

	/**
	 * 添加orderItem
	 * @param orderItem
	 */
	void insertOrderItem(OrderItem orderItem);
	void insertOrderItem(Object[][] params);
	
}
