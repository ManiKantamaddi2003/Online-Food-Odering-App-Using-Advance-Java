package com.tap.model;

public class OrderHistory {
private int oh_id;
private int orderid;
private int rid;
private int uid;
private double total;
private String status;

public OrderHistory() {
	
}
public OrderHistory(int oh_id, int orderid, int rid, int uid, double total, String status) {
	super();
	this.oh_id = oh_id;
	this.orderid = orderid;
	this.rid = rid;
	this.uid = uid;
	this.total = total;
	this.status = status;
}
public int getOh_id() {
	return oh_id;
}
public void setOh_id(int oh_id) {
	this.oh_id = oh_id;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}



}
