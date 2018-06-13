package com.witgame.u3d;

import redis.clients.jedis.Jedis;

public class Redis {

	private static Jedis jedis;

	/**
	 * 获取单列
	 * @return
	 */
	public static Jedis getInstance() {
		if (! (jedis  instanceof  Jedis)) {
			jedis = new Jedis("127.0.0.1", 6379);
		}
		return jedis;

	}
}
