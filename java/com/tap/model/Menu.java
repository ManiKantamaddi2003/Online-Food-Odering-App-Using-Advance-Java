package com.tap.model;

public class Menu
{
  private int menuid;
  private int rid;
  private String name;
  private String description;
  private double price;
  private double rating;
  private String isAvailable;
  private String image;
  
  public Menu()
  {
	  
  }
   public Menu(int menuid, int rid, String name, String description, double price, double rating, String isAvailable,String image) {
	super();
	this.menuid = menuid;
	this.rid = rid;
	this.name = name;
	this.description = description;
	this.price = price;
	this.rating = rating;
	this.isAvailable =isAvailable;
	this.image=image;
	
}
   public Menu(int rid, String name, String description, double price, double rating, String isAvailable,String image) {
	   super();
	   this.rid = rid;
	   this.name = name;
	   this.description = description;
	   this.price = price;
	   this.rating = rating;
	   this.isAvailable= isAvailable;
	   this.image=image;
   }
public int getMenuid() {
	return menuid;
}
public void setMenuid(int menuid) {
	this.menuid = menuid;
}
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public double getRating() {
	return rating;
}
public void setRating(double rating) {
	this.rating = rating;
}
public String getIsAvailable() {
	return isAvailable;
}
public void setIsAvailable(String isActive) {
	this.isAvailable = isAvailable;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
@Override
public String toString() {
    return menuid + " " + rid + " " + name + " " + description + " " + price + " " + rating + " " + isAvailable+" "+image;
}

  
}
