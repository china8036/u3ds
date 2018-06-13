package com.witgame.u3d;

import java.io.IOException;
import java.net.SocketAddress;

import org.json.JSONException;
import org.json.JSONObject;

public class Request {
	
	/**
	 * 控制器键名
	 */
	public final static String CTR_KEY = "ctr";
	
	public final static String SID_KEY = "sid";
	
	JSONObject request;
	
	public SocketThread st;
	
	private String controller;
	
	private String   sid;

	Request(String requestStr,  SocketThread st) throws ResponseException  {
		this.st = st;
		try {
			this.request = new JSONObject(requestStr);
		}catch(JSONException je) {
			throw new ResponseException(je.getMessage() + " body:" + requestStr, ResponseCode.ILLEGAL_REQUEST);
		}
		try {
			 controller = (String) this.request.get(CTR_KEY);
			 sid = (String) this.request.get(SID_KEY);
		}catch(JSONException je) {
			throw new ResponseException(je.getMessage(),  ResponseCode.ILLEGAL_REQUEST);
		}
	}
	
	
	
	/**
	 * 获取键值
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		return this.request.get(key);
	}
	
	
	
	public String getSid() {
		return this.sid;
	}
	
	
	public String getController() {
		return this.controller;
	}
	
	/**
	 *  获取远端地址
	 * @return
	 * @throws IOException 
	 */
	public SocketAddress getRemoteAddress() throws IOException {
		return this.st.getAddress();
	}
}
