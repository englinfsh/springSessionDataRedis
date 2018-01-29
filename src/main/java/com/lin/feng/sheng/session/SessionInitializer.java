package com.lin.feng.sheng.session;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;



public class SessionInitializer extends AbstractHttpSessionApplicationInitializer{
    public SessionInitializer() {
        super(RedisHttpSessionConfig.class);
    }

}
