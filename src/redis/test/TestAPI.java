package redis.test;


import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
* @Title TestAPI
* @Description 本类主要功能是测试redis基本api
* @Company null
* @author 曾敏
* @date 2017年9月16日下午6:32:05
*/
public class TestAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//获取连接
		Jedis jedis = new Jedis("192.168.25.133",6379);

		//测试联通
		System.out.println(jedis.ping());

		//string赋值
		jedis.set("k1", "v1");
		jedis.set("k2", "v2");

		//取值
		System.out.println(jedis.get("k1"));

		//keys *
		Set<String> keys = jedis.keys("*");
		for (String s : keys) {
			System.out.println(s);
		}
		//		System.out.println(keys);

		//新增list
		Long lpush = jedis.lpush("list1","1","2","3");
		System.out.println(lpush);

		//新增set
		Long sadd = jedis.sadd("set1", "1","2","1");
		System.out.println(sadd);

		//取set
		Set<String> set = jedis.smembers("set1");
		for (String set1 : set) {
			System.out.println(set1);
		}





	}

}
