package redis.test;

import redis.clients.jedis.Jedis;

public class TestMS {

	public static void main(String[] args) {
		
		Jedis master = new Jedis("192.168.25.133", 6379);
		Jedis slave = new Jedis("192.168.25.133", 6380);
	
		//配置副机连接主机  生产中一般不用  因为每次slaveof会从主机复制数据到从机  一般是运维的兄弟搞好了的谁主谁从
		slave.slaveof("127.0.0.1", 6379);
		
		//主机写入
		master.set("m1", "m2");
		//从机获取
		String string = slave.get("m1");
		System.out.println(string);
	
	}
}
