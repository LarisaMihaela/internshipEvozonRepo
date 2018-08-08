package com.evozon.utils;




public abstract class BasePage {
	
	 public void sleep(int milliseconds){
	        try {
	            Thread.sleep(milliseconds);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
}
