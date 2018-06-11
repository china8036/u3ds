package com.witgame.u3d;




import com.witgame.u3d.session.MemSession;

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
		String controller= request.getController();
        Session s = new MemSession();
		try {
			Controller ctr = (Controller)Class.forName(CONTROLLER_PACKAGE + controller).newInstance();
			ctr.run(this.request, this.response, s);

		} catch (ClassNotFoundException e) {
			throw new ResponseException(controller + " Controller Not Found", ResponseCode.ILLEGAL_REQUEST); 
		}catch(InstantiationException e) {
			throw new ResponseException(controller + " Controller Instant Failed", ResponseCode.ILLEGAL_REQUEST); 
		}catch(IllegalAccessException e) {
			throw new ResponseException(controller + " Controller Access Failed", ResponseCode.ILLEGAL_REQUEST); 
		}
		
	}
	
	
}
