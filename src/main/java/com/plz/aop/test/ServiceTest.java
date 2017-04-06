package com.plz.aop.test;

import com.plz.aop.annotations.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by andy on 17-4-7.
 */
@Before(pkg = "com.plz.aop.test",cls="ServiceTest")
public class ServiceTest {
    Logger logger = LoggerFactory.getLogger(ServiceTest.class);
    public void showMsg(){
        logger.info("hello torstf");
    }
}
