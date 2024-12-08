package com.tap.Security;

public class Encrypt 
{
    public static String encrypt(String str)
    {
     String newStr="";
     for(int i=0;i<=str.length()-1;i++)
     {
    	 newStr=newStr+((char)(str.charAt(i)+2));
     }
     return newStr;

    }	
}
