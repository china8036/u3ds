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
				String msg = st.getMsg();
				//System.out.println("recv:" + msg);
				if(msg.equals(Protocol.EXIT_CODE)) {//收到退出信息
					return;
				}
				this.route.run(new Request(msg, this.st));
			}catch(ResponseException e) {
				this.response.responseErr(e.getCode(),  e.getMessage(), null);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			 
		}

	}



}
