package com.nqy.mycode.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by abner on 7/23/15.
 */
@Target(ElementType.PARAMETER)
public @interface ParamInfo {
    int version() default 1;
}
