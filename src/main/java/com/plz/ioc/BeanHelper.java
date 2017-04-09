package com.plz.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andy on 17-4-7.
 */
public class BeanHelper {

    static Map<Class<?>,Object> beanMap = new HashMap<>();
    public static <T> T getBean(Class<?> clzz) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if(beanMap.containsKey(clzz)){
            return (T)beanMap.get(clzz);
        }
        Constructor<?> constructor =  clzz.getConstructors()[0];
        Object rtnObj = constructor.newInstance(null);
        setBean(clzz,rtnObj);
        return  (T)rtnObj;
    }

    public static void setBean(Class<?> clzz,Object bean){
        beanMap.put(clzz,bean);
    }
}
