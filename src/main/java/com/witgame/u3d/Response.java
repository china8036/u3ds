package com.witgame.u3d;

import org.json.JSONObject;

public class Response {

 private	SocketThread st;
	
 
	Response(SocketThread st){
	     	this.st = st;
	}
	
	
	public void responseErr(int code, String msg) {
		this.sendJson(code, msg);
	}
	
	
	public void responseOk(JSONObject jo) {
		this.sendJson(ResponseCode.EVERY_OK,  "",  jo);
	}
	
	
	/**
	 * 
	 * @param code
	 * @param msg
	 */
	public void sendJson(int code, String msg) {
		 this.sendJson(code, msg, new JSONObject());
	}
	
	/**
	 * 
	 * @param code
	 * @param msg
	 * @param jo
	 */
	public void sendJson(int code, String msg, JSONObject jo) {
		this.send((new JSONObject()).put("code", code).put("msg", msg).put("data", jo).toString());
	}
	
	
	public void send(String msg) {
		try {
			this.st.sendMsg(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
