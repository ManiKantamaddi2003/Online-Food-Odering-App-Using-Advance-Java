package com.tap.Security;

public class Decrypt 
{
	 public static String decrypt (String str)
	    {
	     String newStr="";
	     for(int i=0;i<=str.length()-1;i++)
	     {
	    	 newStr=newStr+((char)(str.charAt(i)-2));
	     }
	    	return newStr;
	    }	
}
