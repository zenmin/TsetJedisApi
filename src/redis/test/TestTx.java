package redis.test;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
* @Title TestTx
* @Description 本类主要功能是测试redis事务
* @Company null
* @author 曾敏
* @date 2017年9月16日下午6:32:40
*/
public class TestTx {
		
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.25.133",6379);
		
		//监控k3
		jedis.watch("k3");
		//开启事务
		Transaction multi = jedis.multi();
		multi.set("k3", "v32");
		multi.set("k4", "v42");
		
		//执行事务
		List<Object> exec = multi.exec();
		
		//放弃监控
//		jedis.unwatch();
		//放弃事务
//		multi.discard();
		System.out.println(exec);
	}

}
