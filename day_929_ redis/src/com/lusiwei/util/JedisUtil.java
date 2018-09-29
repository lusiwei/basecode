package com.lusiwei.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisUtil {
    private static JedisPool jedisPool;
    static {
        Properties properties=new Properties();
        InputStream resourceAsStream = JedisUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
        try {
            properties.load(resourceAsStream);
            JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
            jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
            jedisPool = new JedisPool(properties.getProperty("host"), Integer.parseInt(properties.getProperty("port")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Jedis getJedisPool() {
        return jedisPool.getResource();
    }
    public static void close(Jedis jedis){
        if (jedis != null) {
            jedis.close();
        }
    }
}
