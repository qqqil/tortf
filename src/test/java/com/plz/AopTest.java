package com.plz;

import com.plz.aop.AOPHelper;
import com.plz.aop.test.AopTest1;
import com.plz.aop.test.ServiceTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by andy on 17-4-7.
 */
public class AopTest {
    Logger logger = LoggerFactory.getLogger(AopTest.class);
    @Test
    public void testAopBefore() throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        ServiceTest serviceTest = AOPHelper.getBean(ServiceTest.class);
        serviceTest.showMsg();
        logger.info("AOP Done!");
    }
}
