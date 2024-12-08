package com.tap.Dao;
import java.util.List;

import com.tap.model.Restaurant;

public interface RestaurantDao {
	    void insert(Restaurant restaurant); 
	    List<Restaurant> fetchAll();
	    Restaurant fetchSpecific(int rid); 
	    int updateRestaurant(Restaurant restaurant); 
	    int deleteRestaurant(int rid);
	}

