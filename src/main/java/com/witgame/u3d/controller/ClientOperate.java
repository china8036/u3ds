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
		String tsid,strOperate;
		 while(iterator.hasNext()){  
		            tsid =iterator.next();
		            System.out.println("client operate tsid:" + tsid);
		            if(tsid.equals(sid)) {
		            	continue;
		            }
		            strOperate =  Redis.getInstance().rpop(Operate.OPERATE_PRE_KEY + tsid);
		            System.out.println("client operate strOperate:" + strOperate);
		            if(strOperate == null) {
		            	continue;
		            }
		            response.responseOk(new JSONObject(strOperate).put("operateId", tsid), request);
		 }
	}

}
