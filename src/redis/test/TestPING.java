package redis.test;

import redis.clients.jedis.Jedis;


/**
* @Title TestPING
* @Description 本类主要功能是测试连通性
* @Company null
* @author 曾敏
* @date 2017年9月16日下午6:32:16
*/
public class TestPING {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("192.168.25.133",6379);
		System.out.println(jedis.ping());
	}

}
