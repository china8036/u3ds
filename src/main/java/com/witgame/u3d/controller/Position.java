package com.witgame.u3d.controller;


import com.witgame.u3d.Controller;
import com.witgame.u3d.Redis;
import com.witgame.u3d.Request;
import com.witgame.u3d.Response;

public class Position extends Controller {


	
	
	public void run(Request request, Response response) {
		
		try {
			System.out.println(request.get("x"));
			System.out.println(request.get("y"));
			System.out.println(request.get("z"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
