package com.witgame.u3d.controller;

import java.util.Iterator;
import java.util.Set;

import org.json.JSONObject;

import com.witgame.u3d.Controller;
import com.witgame.u3d.Redis;
import com.witgame.u3d.Request;
import com.witgame.u3d.Response;
import com.witgame.u3d.Session;

public class Clients extends Controller  {

	@Override
	public void run(Request request, Response response, Session session) {
//		// TODO Auto-generated method stub
		String sid = request.getSid();
		Set<String> clients = Redis.getInstance().smembers("clients");
		System.out.println(clients.toString());
		 for( Iterator<String>   it = clients.iterator();  it.hasNext(); )
	        {           
			   String tsid = it.next();
			   System.out.println(tsid);
	            if(sid.equals(tsid)) {
	            	continue;
	            }    
	            if(!Redis.getInstance().hexists(tsid, "position")){
	            	Redis.getInstance().srem("clients", tsid);
	            	continue;
	            }
	           String tposition = Redis.getInstance().hmget(tsid, "position").get(0);
	           response.responseOk(new JSONObject(tposition).put("id", tsid));
	    } 
	}

}
