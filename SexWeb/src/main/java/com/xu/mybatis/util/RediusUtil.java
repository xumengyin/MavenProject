package com.xu.mybatis.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.*;

import java.util.Map;

/**
 * redis命令和jedis的api保持一致 查询命令即可
 */
public class RediusUtil {

    public static JedisPool jedisPool;

    static {
        String res = "redis-config.xml";
        ClassPathXmlApplicationContext springContext = Utils.getSpringContext(res);
        jedisPool = springContext.getBean(JedisPool.class);
    }

    public static Transaction openTransaction() {
        Jedis jedis = jedisPool.getResource();
        return jedis.multi();
    }

    public static void execTransaction(Transaction transaction) {
        transaction.exec();
    }

    //存储哈希对象
    public static String hmset(String key, Map<String, String> obj) {
        return hmset(key, obj, 0);
    }

    public static String hmset(String key, Map<String, String> obj, int indexDb) {
        Jedis jedis = null;
        String statusCode = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexDb);
            statusCode = jedis.hmset(key, obj);
        } catch (Exception e) {

        } finally {
            closeJedis(jedis);
        }
        return statusCode;
    }

    public static String listen() {
        Jedis jedis = null;
        String statusCode = null;
        try {
            jedis = jedisPool.getResource();
            jedis.subscribe(new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
                    super.onMessage(channel, message);
                    Log.d("message:" + message);
                }
            }, "xu");
        } catch (Exception e) {

        } finally {
            // closeJedis(jedis);
        }
        return statusCode;
    }


    public static String set(String key, String value) {
        Jedis jedis = null;
        String statusCode = null;
        try {
            jedis = jedisPool.getResource();
            statusCode = jedis.set(key, value);
        } catch (Exception e) {

        } finally {
            closeJedis(jedis);
        }
        return statusCode;
    }

    public static long lpush(String key, String... value) {
        Jedis jedis = null;
        long statusCode = 0;
        try {
            jedis = jedisPool.getResource();
            statusCode = jedis.lpush(key, value);
        } catch (Exception e) {

        } finally {
            closeJedis(jedis);
        }
        return statusCode;
    }

    public static void closeJedis(Jedis jedis) {
        try {
            if (null != jedis) {
                jedis.close();
            }
        } catch (Exception e) {
            Log.d("closeResource failed." + e);
        }
    }

}
