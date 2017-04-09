package com.plz.aop;

import com.plz.aop.annotations.Before;
import com.plz.aop.test.AopTest1;
import com.plz.aop.test.ServiceTest;
import com.plz.ioc.BeanHelper;
import com.plz.ioc.IOCHelper;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by andy on 17-4-7.
 */
public class AOPHelper {
    static Logger logger = LoggerFactory.getLogger(AOPHelper.class);
    static AopTest1 tt = new AopTest1();

    public static <T> T getBean(Class<?> clzz) throws IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException {
        T bean = BeanHelper.getBean(clzz);
        IOCHelper.doInject(bean);
        doAopProxy(clzz);
        bean = BeanHelper.getBean(clzz);
        IOCHelper.doInject(bean);
        return bean;
    }

    /**
     *
     * @param clzz
     * @throws ClassNotFoundException
     */
    public static void doAopProxy(Class<?> clzz) throws ClassNotFoundException {
        for(Method m : AopTest1.class.getDeclaredMethods()){
            if(m.isAnnotationPresent(Before.class)){
                //BeanHelper.setBean(clzz,createProxy(clzz));
                Before annotation = m.getAnnotation(Before.class);

                String pkg = annotation.pkg();
                String clz = annotation.cls();
                String clssStr = pkg+"."+clz;
                String targetClssName = clzz.getCanonicalName();
                if(clssStr.equals(targetClssName)){
                    Class<?> clzz1 = Class.forName(clssStr);
                    Object obj = createProxy(clzz1,m);
                    BeanHelper.setBean(clzz1,obj);
                }
            }
        }
    }

    public static Object createProxy(Class<?> clzz,Method aopMethod){
        return Enhancer.create(clzz,
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                        logger.info("call method by proxy:"+method.getName());
                        aopMethod.invoke(tt,args);
                        proxy.invokeSuper(obj,args);

                        return null;
                    }
                });
    }
}
