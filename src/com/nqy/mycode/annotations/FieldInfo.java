package com.nqy.mycode.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by abner on 7/23/15.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface FieldInfo {
    int value();
}
