package com.witgame.u3d;

import org.json.JSONException;
import org.json.JSONObject;

public class Request {
	
	JSONObject request;

	Request(String requestStr) throws ResponseException  {;
		try {
			this.request = new JSONObject(requestStr);
		}catch(JSONException je) {
			throw new ResponseException(je.getMessage(), ResponseCode.ILLEGAL_REQUEST);
		}
	}
	
	
	public Object get(String key) {
		return this.request.get(key);
	}
}
