package com.plz.aop.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by andy on 17-4-7.
 */

public class ServiceTest {
    Logger logger = LoggerFactory.getLogger(ServiceTest.class);
    public void showMsg(){
        logger.info("hello torstf");
    }
}
