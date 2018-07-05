package com.witgame.u3d.controller;

import java.util.HashMap;

import org.json.JSONObject;

import com.witgame.u3d.Controller;
import com.witgame.u3d.Player;
import com.witgame.u3d.Request;
import com.witgame.u3d.Response;
import com.witgame.u3d.Session;

public class InitPlayer extends Controller {

	public static HashMap<String, Player> players = new HashMap<String, Player>();

	public synchronized void run(Request request, Response response, Session session) {
		String sid = request.getSid();
		if (players.containsKey(sid)) {// 排重处理
			return;
		}
		int num = players.size();
		Player newPlayer = new Player();
		newPlayer.position.x = - num * 2f; // 初始位置偏移 防止重合
		newPlayer.position.z = 0f;
		newPlayer.position.y = 1f;
		if (num == 0) {
			newPlayer.isMaster = true;
		}
		players.put(sid, newPlayer);
		JSONObject data = new JSONObject().put("initPlayerId", sid).put("x", newPlayer.position.x).put("y", newPlayer.position.y).put("z", newPlayer.position.z);
		data.put("isMaster", newPlayer.isMaster);
		response.responseOk(data, request);
	}
}
