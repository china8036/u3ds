package com.witgame.u3d;


public interface Session {

	public Object get(String key);
	
	void set(String key, String value); 
	
	void save() ;
	
	void delete();
	
}
