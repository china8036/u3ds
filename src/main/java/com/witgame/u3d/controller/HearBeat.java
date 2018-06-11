package com.witgame.u3d.controller;



import org.json.JSONObject;

import com.witgame.u3d.Controller;
import com.witgame.u3d.Request;
import com.witgame.u3d.Response;
import com.witgame.u3d.Session;


public class HearBeat extends Controller {

	@Override
	public void run(Request request, Response response, Session session) {
		response.responseOk(new JSONObject().put("result", "Pong"));
	}

}
