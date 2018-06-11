package com.witgame.u3d;

public abstract  class Controller {
	

	protected Controller() {
	}
	
	
	public abstract void run(Request request, Response response, Session session);
}
