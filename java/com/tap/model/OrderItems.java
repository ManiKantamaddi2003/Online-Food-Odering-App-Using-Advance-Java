package com.tap.model;

public class OrderItems 
{
 private int  orderitemid;
 private int orderid;
 private int menuid;
 private int quantity;
 private double total_item;
 
 public OrderItems() {
		super();
	}
	public OrderItems(int orderitemid, int orderid, int menuid, int quantity, double total_item) {
		super();
		this.orderitemid = orderitemid;
		this.orderid = orderid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.total_item = total_item;
	}
	
	public OrderItems(int orderid, int menuid, int quantity, double total_item) {
		super();
		this.orderid = orderid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.total_item = total_item;
	}

public int getOrderitemid() {
	return orderitemid;
}


public void setOrderitemid(int orderitemid) {
	this.orderitemid = orderitemid;
}


public int getOrderid() {
	return orderid;
}


public void setOrderid(int orderid) {
	this.orderid = orderid;
}


public int getMenuid() {
	return menuid;
}


public void setMenuid(int menuid) {
	this.menuid = menuid;
}


public int getQuantity() {
	return quantity;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}


public double getTotal_item() {
	return total_item;
}


public void setTotal_item(double total_item) {
	this.total_item = total_item;
}

@Override
public String toString() {
	return "OrderItems [orderitemid=" + orderitemid + ", orderid=" + orderid + ", menuid=" + menuid + ", quantity="
			+ quantity + ", total_item=" + total_item + "]";
}
}
 
 