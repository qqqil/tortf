package com.plz.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by andy on 17-4-7.
 */
public class BaseAspect implements InvocationHandler {
    Logger logger = LoggerFactory.getLogger(BaseAspect.class);
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("invoke method "+method.getName());
        return null;
    }
}
