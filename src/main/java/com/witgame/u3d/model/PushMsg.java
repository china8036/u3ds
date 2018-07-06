package com.witgame.u3d.model;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.json.JSONObject;


public class PushMsg {
	
	public final static int QUEUE_LEN = 100;
	
	public static HashMap<String, BlockingQueue<JSONObject>> msgMap = new HashMap<String, BlockingQueue<JSONObject>>();
	
	/**
	 * 增加消息 会阻塞
	 * @param sid
	 * @param msg
	 * @throws InterruptedException 
	 */
	public static void addMsg(String sid, JSONObject msg) throws InterruptedException {
		if(!msgMap.containsKey(sid)) {
			msgMap.put(sid, new LinkedBlockingQueue<JSONObject>(QUEUE_LEN));
		}
		msgMap.get(sid).put(msg);
	}
	
	
	public static JSONObject getMsg(String sid) throws InterruptedException {
		if(!msgMap.containsKey(sid)) {
			msgMap.put(sid, new LinkedBlockingQueue<JSONObject>(QUEUE_LEN));
		}
		return msgMap.get(sid).take();
		
	}
	
	/**
	 * 添加信息给所有客服端
	 * @param msg
	 */
	public static void addMsgToAll(JSONObject msg) {
	    for(BlockingQueue<JSONObject> v:msgMap.values())
        {
	    	try {
				v.put(msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
	}
	
	
}
