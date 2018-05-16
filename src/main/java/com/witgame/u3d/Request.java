package com.witgame.u3d;

import org.json.JSONObject;

public class Request {
	
	JSONObject request;

	Request(String requestStr){
		this.request = new JSONObject(requestStr);
	}
	
	
	public Object get(String key) {
		return this.request.get(key);
	}
}
