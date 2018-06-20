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
		String clients = Redis.getInstance().get(Position.CLIENT_EKY);
		if(clients == null) {
			return ;
		}
		System.out.println(clients);
		JSONObject clientsObject = new JSONObject(clients);
		Iterator<String> iterator = clientsObject.keys();  
		 while(iterator.hasNext()){  
		            String tsid =iterator.next();  
		            if(tsid.equals(sid)) {
		            	continue;
		            }
		            JSONObject position = clientsObject.getJSONObject(tsid);
		            response.responseOk(position.put("id", tsid), request);
		 }
	}

}
