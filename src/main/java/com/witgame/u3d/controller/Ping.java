package com.witgame.u3d.controller;

import org.json.JSONObject;

import com.witgame.u3d.Controller;
import com.witgame.u3d.Request;
import com.witgame.u3d.Response;

public class Ping extends Controller {

	@Override
	public void run(Request request, Response response) {
		response.responseOk(new JSONObject().put("result", "Pong"));
	}

}
