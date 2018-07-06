package com.witgame.u3d.controller;



import org.json.JSONObject;

import com.witgame.u3d.Controller;
import com.witgame.u3d.Redis;
import com.witgame.u3d.Request;
import com.witgame.u3d.Response;
import com.witgame.u3d.Session;
import com.witgame.u3d.Vector3;
import com.witgame.u3d.model.Players;
import com.witgame.u3d.model.PushMsg;

public class Position extends Controller {


	public final static String CLIENT_EKY = "clients";
	
	
	public void run(Request request, Response response, Session session) {
		
		try {
			String positoinId = (String)request.get("positionId");
			if(positoinId.equals("")) {
				System.out.println("not rec positionId" );
				return ;
			}
			if(!Players.players.containsKey(positoinId)) {
				System.out.println("not found this positionId:"  + positoinId );
				return ;
			}
			//Players.players.get(positoinId).position.x = (Float)request.get("x");
			JSONObject positon = new JSONObject().put("positionId", positoinId).put("x", request.get("x")).put("y", request.get("y")).put("z", request.get("z"));
			PushMsg.addMsgToAll(positon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
