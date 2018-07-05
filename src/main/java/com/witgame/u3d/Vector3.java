package com.witgame.u3d;

/**
 *  三维矢量
 * @author wang
 *
 */
public class Vector3 {

	/**
	 * x
	 */
	public float x;
	
	
	/**
	 * y
	 */
	public float y;
	
	
	/**
	 * z
	 */
	public float z;
	
	public Vector3() {
		
	}
	
	
	public Vector3(Float x,  Float y, Float z){
		this.x = x.floatValue();
		this.y = y.floatValue();
		this.z = z.floatValue();
	}
	
	public Vector3(float x,  float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
