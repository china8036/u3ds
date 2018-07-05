package com.witgame.u3d;

import java.util.ArrayList;

public class Player {

	/**
	 * name
	 */
	public String name;
	
	
	public boolean isMaster = false;
	
	
	/**
	 * 位置 暂时可以保存一个变量 可以被下次更新覆盖
	 */
	public  Vector3 position = new Vector3();
	
	
	/**
	 * 每次受力都要保存并执行 不能被下次更新掉
	 */
	
	public ArrayList<Vector3> force = new ArrayList<Vector3>();
   
}
