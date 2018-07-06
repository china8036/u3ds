package com.witgame.u3d.controller;



import org.json.JSONObject;

import com.witgame.u3d.Controller;
import com.witgame.u3d.Request;
import com.witgame.u3d.Response;
import com.witgame.u3d.Session;
import com.witgame.u3d.model.Players;
import com.witgame.u3d.model.PushMsg;

public class Operate extends Controller {
	
	public void run(Request request, Response response, Session session) {
		
		
		try {
			String sid = request.getSid();
			if(!Players.players.containsKey(sid)) {
				System.out.println("未初始化的player:" + sid);
			}
			JSONObject opera = new JSONObject();
			opera.put("x", request.get("x"));
			opera.put("y", request.get("y"));
			opera.put("z", request.get("z"));
			opera.put("t", request.get("t"));
			opera.put("operateId", sid);
			PushMsg.addMsg(Players.mastePlayerId, opera);//主动发送给master slave的操作记录
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
