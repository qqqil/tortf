package com.plz.aop;

import com.plz.aop.annotations.Before;
import com.plz.ioc.BeanHelper;
import com.plz.ioc.IOCHelper;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * Created by andy on 17-4-7.
 */
public class AOPHelper {

    public static <T> T getBean(Class<?> clzz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T bean = BeanHelper.getBean(clzz);
        IOCHelper.doInject(bean);

    }
    public static void doAopProxy(Object obj){
        if(obj.getClass().isAnnotationPresent(Before.class)){
            Enhancer enhancer = Enhancer.create()
        }
    }
}
