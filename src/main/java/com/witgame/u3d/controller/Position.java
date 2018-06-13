package com.witgame.u3d.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

import com.witgame.u3d.Controller;
import com.witgame.u3d.Redis;
import com.witgame.u3d.Request;
import com.witgame.u3d.Response;
import com.witgame.u3d.Session;

public class Position extends Controller {


	public void run(Request request, Response response, Session session) {
		
		try {
			String sid = request.getSid();
			if(!Redis.getInstance().sismember("clients", sid)) {//添加到clients
				Set<String> clients = Redis.getInstance().smembers("clients");
				clients.add(sid);
				String[] clientsArray = new String[clients.size()];
				clients.toArray(clientsArray);
				Redis.getInstance().sadd("clients", clientsArray);
			}
		   //更新位置信息
			JSONObject position = new JSONObject();
			position.put("x", request.get("x"));
			position.put("y", request.get("y"));
			position.put("z", request.get("z"));
			System.out.println("recv position:"  + position.toString());
			Map<String, String> postionMap = new HashMap<String, String>();
			postionMap.put("position", position.toString());
			Redis.getInstance().hmset(sid, postionMap);
			System.out.println("update position:" + Redis.getInstance().hmget(sid, "position"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
