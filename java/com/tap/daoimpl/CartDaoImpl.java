package com.tap.daoimpl;

import java.util.HashMap;
import java.util.Map;

import com.tap.model.CartItem;

public class CartDaoImpl {
	
    public Map<Integer, CartItem> addItem(CartItem newItem, Map<Integer, CartItem> items) {
    	
        int itemId = newItem.getItemId();
        if (items.containsKey(itemId)) {
           System.out.println("old item");
            CartItem existingItem = items.get(itemId);
            existingItem.setQuantity(existingItem.getQuantity() + newItem.getQuantity());
        } else {
          System.out.println("new item");
            items.put(itemId, newItem);
        }
        return items; 
    }
    
    public Map<Integer, CartItem> updateCartItem(int itemId, int quantity, Map<Integer, CartItem> items) {
       
        if (items.containsKey(itemId)) {
          
            CartItem item = items.get(itemId);
            
            if (quantity > 0) {
                item.setQuantity(quantity);
                System.out.println("Item quantity updated: " + item.getName() + " to " + quantity);
            } else {
                System.out.println("Invalid quantity. Item not updated.");
            }
        } else {
            System.out.println("Item not found in the cart.");
        }
        return items; 
    }
    
   


    
}

