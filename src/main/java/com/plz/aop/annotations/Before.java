package com.plz.aop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by andy on 17-4-7.
 */
@Target(ElementType.METHOD)

@Retention(RetentionPolicy.RUNTIME)
public @interface Before{
    String pkg();
    String cls();

}
