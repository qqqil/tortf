package com.plz.aop.test;

import com.plz.aop.annotations.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by andy on 17-4-10.
 */

public class AopTest1 {

    Logger logger = LoggerFactory.getLogger(AopTest1.class);

    @Before(pkg = "com.plz.aop.test",cls="ServiceTest")
    public void before(){
        logger.info("call before");
    }
}
