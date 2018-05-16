package com.witgame.u3d;


public class TaskThread implements Runnable {

	private SocketThread st;

	
	Route   route;
	
	Response response;

	TaskThread(SocketThread st) {
		this.st = st;
		this.response = new Response(this.st); 
		this.route = new Route(this.response);
	}

	/**
	 * 负责处理请求
	 */
	public void run() {
		while (true) {
			try {
				this.route.run(new Request(st.getMsg()));
			}catch(ResponseException e) {
				this.response.responseErr(e.getCode(),  e.getMessage());
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			 
		}

	}



}
