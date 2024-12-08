package com.tap.model;

public class Restaurant 
{
  private int rid;
  private String rname;
  private String cusineType;
  private double ratings;
  private String address;
  private  String isActive;
  private String image;
  
  public Restaurant() {
	  
  }
  public Restaurant(int rid, String rname, String cusineType, double ratings, String address, String isActive,String image) {
	super();
	this.rid = rid;
	this.rname = rname;
	this.cusineType = cusineType;
	this.ratings = ratings;
	this.address = address;
	this.isActive = isActive;
	this.image=image;
}
  
  public Restaurant(String rname, String cusineType, double ratings, String address, String isActive,String image) {
	  super();
	  this.rname = rname;
	  this.cusineType = cusineType;
	  this.ratings = ratings;
	  this.address = address;
	  this.isActive = isActive;
	  this.image=image;
  }
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
public String getRname() {
	return rname;
}
public void setRname(String rname) {
	this.rname = rname;
}
public String getCusineType() {
	return cusineType;
}
public void setCusineType(String cusineType) {
	this.cusineType = cusineType;
}
public double getRatings() {
	return ratings;
}
public void setRatings(double ratings) {
	this.ratings = ratings;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getIsActive() {
	return isActive;
}
public void setIsActive(String isActive) {
	this.isActive = isActive;
}
public String getImage() {
    return image;
}

public void setImage(String image) {
    this.image = image;
}

@Override
public String toString() {
	return  rname+" "+cusineType+" "+ratings+" "+address+" "+isActive;
}

}
