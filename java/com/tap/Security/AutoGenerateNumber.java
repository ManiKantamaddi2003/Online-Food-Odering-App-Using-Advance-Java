package com.tap.Security;

import com.tap.daoimpl.OrderDaoImpl;

public class AutoGenerateNumber {
	
	public static int generateUniqueOrderId() {
       
        int maxOrderId = OrderDaoImpl.getLastOrderIdFromDatabase();
        System.out.println(maxOrderId );
        
       
        if (maxOrderId == 0) {
            return 1;  
        } else {
            
            return maxOrderId + 1;
        }
    }
}