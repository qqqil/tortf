package com.plz.ioc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import com.plz.ioc.annotations.Inject;
/**
 * Created by andy on 17-4-7.
 */
public class IOCHelper {


    /**
     *
     * @param obj
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public static  void doInject(Object obj) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field f : fields){
            f.setAccessible(true);
            if(f.isAnnotationPresent(Inject.class)){
                Object fieldVal = BeanHelper.getBean(f.getType());
                f.set(obj,fieldVal);
            }
        }
    }
}
