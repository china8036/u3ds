package com.witgame.u3d;

import org.json.JSONObject;

public class Response {

 private	SocketThread st;
	
 
	Response(SocketThread st){
	     	this.st = st;
	}
	
	/**
	 * 回复错误信息
	 * @param code
	 * @param msg
	 * @param request
	 */
	public void responseErr(int code, String msg, Request request) {
		this.sendJson(code, msg, request);
	}
	
	/**
	 * 回复正常的json数据
	 * @param jo
	 * @param request
	 */
	public void responseOk(JSONObject jo, Request request) {
		this.sendJson(ResponseCode.EVERY_OK,  "",  jo, request);
	}
	
	
	/**
	 * 回复 code msg
	 * @param code
	 * @param msg
	 * @param request
	 */
	public void sendJson(int code, String msg, Request request) {
		 this.sendJson(code, msg, new JSONObject(),   request);
	}
	
	/**
	 * 回复标准的json数据
	 * @param code
	 * @param msg
	 * @param jo
	 * @param request
	 */
	public void sendJson(int code, String msg, JSONObject jo,  Request request) {
		JSONObject jMsg = new JSONObject().put("code", code).put("msg", msg).put("data", jo);
		if(request == null) {
			this.send(jMsg.toString());
		}else {
			this.send(jMsg.put(Request.CTR_KEY, request.getController()).toString());
		}
	}
	
	
	public void send(String msg) {
		try {
			this.st.sendMsg(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
