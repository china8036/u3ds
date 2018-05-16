package com.witgame.u3d;


public class Response {

 private	SocketThread st;
	
 
	Response(SocketThread st){
	     	this.st = st;
	}
	
	
	
	
	public void send(String msg) {
		try {
			this.st.sendMsg(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
