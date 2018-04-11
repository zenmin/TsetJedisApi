package redis.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * @Title TestPool
 * @Description 本类主要功能是Redis池调用
 * @Company null
 * @author 曾敏
 * @date 2017年9月16日下午7:57:04
 */
public class TestPool {
	public static void main(String[] args) {
		//创建池
		JedisPool pool = JedisPoolUtil.getJedisPoolInstance();
		//创建连接
		Jedis	 jedis  = null ;
		try {
			//从池中获取连接
			jedis= pool.getResource();
			String s = jedis.set("k1", "v5");
			System.out.println(s);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JedisPoolUtil.release(pool, jedis);
		}
	}
}
