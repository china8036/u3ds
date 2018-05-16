package com.witgame.u3d;


public class TaskThread implements Runnable {

	SocketThread st;
	
	Request request;
	
	Response response;
	
	

	TaskThread(SocketThread st) {
		this.st = st;
		this.response = new Response(this.st);
	}

	public void run() {
		while (true) {
			this.request = new Request(st.getMsg());
			
		}
		// TODO Auto-generated method stub

	}

	public void sendMsg(String msg) {
		try {
			st.sendMsg(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
