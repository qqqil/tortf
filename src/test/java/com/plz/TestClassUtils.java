package com.plz;

import com.plz.bean.ClassRoom;
import com.plz.bean.User;
import com.plz.ioc.BeanHelper;
import com.plz.ioc.IOCHelper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by andy on 17-4-6.
 */
public class TestClassUtils {
    Logger logger = LoggerFactory.getLogger(TestClassUtils.class);
    @Test
    public void testGetBean() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        User user = BeanHelper.getBean(User.class);
        ClassRoom clssRoom = BeanHelper.getBean(ClassRoom.class);
        IOCHelper.doInject(clssRoom);
        logger.info("Done");
    }
}
