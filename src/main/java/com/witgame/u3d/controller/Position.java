package com.witgame.u3d.controller;



import org.json.JSONObject;

import com.witgame.u3d.Controller;
import com.witgame.u3d.Redis;
import com.witgame.u3d.Request;
import com.witgame.u3d.Response;
import com.witgame.u3d.Session;

public class Position extends Controller {


	public final static String CLIENT_EKY = "clients";
	
	
	public void run(Request request, Response response, Session session) {
		
		try {
			String sid = request.getSid();
			JSONObject position = new JSONObject();
			position.put("x", request.get("x"));
			position.put("y",  request.get("y"));
			position.put("z",  request.get("z"));
			System.out.println("recv position:"  + position.toString());
			String clients = Redis.getInstance().get(CLIENT_EKY);
			JSONObject  clientsObject;
			if(clients == null || !clients.startsWith("{")) {
				clientsObject= new JSONObject();
			}else {
				System.out.println("clients:" + clients);
				clientsObject= new JSONObject(clients);
			}
			
			clientsObject.put(sid, position);
			System.out.println("clientsObject:"  + clientsObject.toString());
			Redis.getInstance().set(CLIENT_EKY,  clientsObject.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
