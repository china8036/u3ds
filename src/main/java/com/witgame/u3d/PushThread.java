package com.witgame.u3d;

import com.witgame.u3d.model.PushMsg;

public class PushThread implements Runnable {

	String sid;
	
	Response response;
	
	
	public PushThread(String sid, Response response) {
		this.sid = sid;
		this.response = response;
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				response.responseOk(PushMsg.getMsg(this.sid), null);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
