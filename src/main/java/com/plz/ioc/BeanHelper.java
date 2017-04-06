package com.plz.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by andy on 17-4-7.
 */
public class BeanHelper {
    public static <T> T getBean(Class<?> clzz) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor =  clzz.getConstructors()[0];
        Object rtnObj = constructor.newInstance(null);
        return  (T)rtnObj;
    }
}
