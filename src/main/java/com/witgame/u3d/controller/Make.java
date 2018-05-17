package com.witgame.u3d.controller;

import com.witgame.u3d.Controller;
import com.witgame.u3d.Request;
import com.witgame.u3d.Response;

public class Make extends Controller {


	
	
	public void run(Request request, Response response) {
		System.out.println(request.get("name"));
		
	}
}
