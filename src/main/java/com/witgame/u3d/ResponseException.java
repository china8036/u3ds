package com.witgame.u3d;


public class ResponseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code;
	
	ResponseException (String msg, int code){
		 super(msg);
		 this.code = code;
		
	}
	
	
	public int getCode() {
		return this.code;
	}

}
