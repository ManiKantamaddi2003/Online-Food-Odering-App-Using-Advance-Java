package com.tap.model;

public class Orders {
	private int orderid;
	private int uid;
	private int rid;
	private int menuid;
	private int quantity;
	private double total;
	private String payment_method;
	private String status;
	public Orders()
	{
		
	}
	public Orders(int uid, int rid, int menuid, int quantity, double total, String payment_method,
			String status) {
		super();
		this.uid = uid;
		this.rid = rid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.total = total;
		this.payment_method = payment_method;
		this.status = status;
	}
	public Orders(int orderid, int uid, int rid, int menuid, int quantity, double total, String payment_method,
			String status) {
		super();
		this.orderid = orderid;
		this.uid = uid;
		this.rid = rid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.total = total;
		this.payment_method = payment_method;
		this.status = status;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		 
    return uid+" "+rid+" "+menuid+" "+quantity+" "+total+" "+payment_method;
	}
}
