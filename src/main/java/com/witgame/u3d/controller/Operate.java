package com.witgame.u3d.controller;



import org.json.JSONObject;

import com.witgame.u3d.Controller;
import com.witgame.u3d.Player;
import com.witgame.u3d.Redis;
import com.witgame.u3d.Request;
import com.witgame.u3d.Response;
import com.witgame.u3d.Session;
import com.witgame.u3d.Vector3;

public class Operate extends Controller {


	public final static  String OPERATE_PRE_KEY = "operate_";
	
	public void run(Request request, Response response, Session session) {
		
		
		
		
		try {
			String sid = request.getSid();
			if(!InitPlayer.players.containsKey(sid)) {
				System.out.println("未初始化的player:" + sid);
			}
			Vector3 force = new Vector3((Float)request.get("x"), (Float)request.get("y"), (Float)request.get("z"));
			InitPlayer.players.get(sid).force.add(force);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
