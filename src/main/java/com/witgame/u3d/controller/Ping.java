package com.witgame.u3d.controller;


import java.io.IOException;

import org.json.JSONObject;

import com.witgame.u3d.Controller;
import com.witgame.u3d.Request;
import com.witgame.u3d.Response;

public class Ping extends Controller {

	@Override
	public void run(Request request, Response response) {
		Double revTime = (Double) request.get("time");
		try {
			System.out.println(request.getRemoteAddress());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.responseOk(new JSONObject().put("result", "Pong").put("time",  revTime.doubleValue() ));
	}

}
