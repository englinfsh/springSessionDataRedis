package com.lin.feng.sheng.session;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@EnableRedisHttpSession(
		maxInactiveIntervalInSeconds= 1800,
		redisNamespace="icsSpringSession",
		redisFlushMode=RedisFlushMode.ON_SAVE)
public class RedisHttpSessionConfig implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -3049060689971404123L;

	//冒号后的值为没有配置文件时，制动装载的默认值
    @Value("${redis.hostname:127.0.0.1}")
    private String HostName;
    @Value("${redis.port:6379}")
    private int Port;

    @Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory connection = new JedisConnectionFactory();
        connection.setPort(Port);
        connection.setHostName(HostName);
        return connection;
    }


    /**
     *
     * 因为我使用的是redis2.8+以下的版本，使用RedisHttpSessionConfiguration配置时。
     * 会报错误：ERR Unsupported CONFIG parameter: notify-keyspace-events
     * 是因为旧版本的redis不支持“键空间通知”功能，而RedisHttpSessionConfiguration默认是启动通知功能的
     * 解决方法有：
     * （1）install Redis 2.8+ on localhost and run it with the default port (6379)。
     * （2）If you don't care about receiving events you can disable the keyspace notifications setup。
     * 如本文件，配置ConfigureRedisAction的bean为不需要打开的模式。
     * 另外一种方式是在xml中。
     * <util:constant static-field="org.springframework.session.data.redis.config.ConfigureRedisAction.NO_OP"/>
     *
     */
    @Bean
    public ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }




}
