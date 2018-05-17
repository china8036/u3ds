package com.witgame.u3d;



import org.json.JSONException;

public class Route {

	Response response;
	
	Request   request;
	
	private final String CONTROLLER_PACKAGE = "com.witgame.u3d.controller.";
	
	Route(Response response){
	         this.response = response;
	}
	
	/**
	 * 请求分发
	 * @param request
	 */
	public void run(Request request) throws ResponseException {
		this.request = request;
		String controller;
		try {
			 controller = (String) this.request.get("ctr");
		}catch(JSONException je) {
			throw new ResponseException(je.getMessage(),  ResponseCode.ILLEGAL_REQUEST);
		}

		try {
			Controller ctr = (Controller)Class.forName(CONTROLLER_PACKAGE + controller).newInstance();
			ctr.run(this.request, this.response);

		} catch (ClassNotFoundException e) {
			throw new ResponseException(controller + " Controller Not Found", ResponseCode.ILLEGAL_REQUEST); 
		}catch(InstantiationException e) {
			throw new ResponseException(controller + " Controller Instant Failed", ResponseCode.ILLEGAL_REQUEST); 
		}catch(IllegalAccessException e) {
			throw new ResponseException(controller + " Controller Access Failed", ResponseCode.ILLEGAL_REQUEST); 
		}
		
	}
	
	
}
