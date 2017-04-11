package com.plz;

import com.plz.utils.ClassUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by andy on 17-4-12.
 */
public class ClassUtilsTest {
    Logger logger = LoggerFactory.getLogger(ClassUtilsTest.class);

    @Test
    public void testGetClasses() throws IOException {
        List<Class<?>> classes = ClassUtils.getClassesList("com.plz.aop".replaceAll("\\.","/"));

        logger.info("get classes");
    }
}
