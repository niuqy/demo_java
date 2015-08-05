package com.nqy.mycode.annotations;

import java.lang.annotation.*;

/**
 * Created by abner on 7/22/15.
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "niuqinyong@gmail.com";
    String date();
    int version() default 1;
}
