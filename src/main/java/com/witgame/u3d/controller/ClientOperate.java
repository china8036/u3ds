package com.witgame.u3d.controller;

import java.util.Iterator;
import java.util.Set;

import org.json.JSONObject;

import com.witgame.u3d.Controller;
import com.witgame.u3d.Redis;
import com.witgame.u3d.Request;
import com.witgame.u3d.Response;
import com.witgame.u3d.Session;

public class ClientOperate extends Controller  {

	@Override
	public void run(Request request, Response response, Session session) {
//		// TODO Auto-generated method stub
		String sid = request.getSid();
		String clients = Redis.getInstance().get(Position.CLIENT_EKY);
		if(clients == null || !clients.startsWith("{")) {
			return ;
		}
		System.out.println(clients);
		JSONObject operatesObject = new JSONObject(clients);
		Iterator<String> iterator = operatesObject.keys();  
		 while(iterator.hasNext()){  
		            String tsid =iterator.next();  
		            if(tsid.equals(sid)) {
		            	continue;
		            }
		            String strOperate =  Redis.getInstance().rpop(Operate.OPERATE_PRE_KEY + tsid);
		            if(strOperate == null) {
		            	continue;
		            }
		            System.out.println("strOperate:" + strOperate);
		            response.responseOk(new JSONObject(strOperate).put("operateId", tsid), request);
		 }
	}

}
