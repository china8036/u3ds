package com.witgame.u3d;

public class Route {

	Response response;
	
	Request   request;
	
	
	Route(Response response){
	         this.response = response;
	}
	
	/**
	 * 请求分发
	 * @param request
	 */
	public void run(Request request) {
		this.request = request;
		System.out.println(this.request.get("name"));
		
	}
	
	
}
