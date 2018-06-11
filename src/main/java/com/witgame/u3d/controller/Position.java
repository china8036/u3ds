package com.witgame.u3d.controller;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
			Redis.getInstance().sadd("clients", sid);
			JSONObject position = new JSONObject();
			position.put("x", request.get("x"));
			position.put("y", request.get("y"));
			position.put("z", request.get("z"));
			Map<String, String> postionMap = new HashMap<String, String>();
			postionMap.put("position", position.toString());
			Redis.getInstance().hmset(sid, postionMap);
			Set<String> clients = Redis.getInstance().smembers("clients");
			 for( Iterator<String>   it = clients.iterator();  it.hasNext(); )
		        {           
				   String tsid = it.next();
		            if(sid.equals(tsid)) {
		            	continue;
		            }    
		            if(Redis.getInstance().hexists(tsid, "position")){
		            	Redis.getInstance().srem("clients", tsid);
		            	continue;
		            }
		           String tposition = Redis.getInstance().hmget(tsid, "position").get(0);
		           response.responseOk(new JSONObject(tposition));
		    } 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
