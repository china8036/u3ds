package com.witgame.u3d.controller;



import org.json.JSONObject;

import com.witgame.u3d.Controller;
import com.witgame.u3d.Redis;
import com.witgame.u3d.Request;
import com.witgame.u3d.Response;
import com.witgame.u3d.Session;

public class Operate extends Controller {


	public final static  String OPERATE_PRE_KEY = "operate_";
	
	public void run(Request request, Response response, Session session) {
		
		
		
		
		try {
			String sid = request.getSid();
			JSONObject operate = new JSONObject();
			operate.put("x", request.get("x"));
			operate.put("y",  request.get("y"));
			operate.put("z",  request.get("z"));
			System.out.println("before store:" + operate.toString());
			Redis.getInstance().lpush(OPERATE_PRE_KEY + sid,  operate.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
