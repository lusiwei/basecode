package com.lusiwei.test;

import com.alibaba.fastjson.JSON;
import com.lusiwei.dao.EmpDao;
import com.lusiwei.pojo.Emp;
import com.lusiwei.util.JDBCUtil;
import com.lusiwei.util.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class TestRedis {
    @Test
    public void t1() {
        JedisPool jedisPool = new JedisPool("localhost", 6379);
        Jedis resource = jedisPool.getResource();
        resource.set("aaaaaaaa", "bbbbbbbbbbbbb");
        resource.close();
    }

    @Test
    public void t2() {
        Jedis jedisPool = JedisUtil.getJedisPool();
        jedisPool.set("88888", "3928492");
        JedisUtil.close(jedisPool);
    }

    @Test
    public void t3() {
//        List<Emp> emps = new EmpDao().queryEmpByDept();
//        System.out.println(JSON.toJSONString(emps));
//        System.out.println(JDBCUtil.getDs());
    }
}
