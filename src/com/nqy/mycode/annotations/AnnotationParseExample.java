package com.nqy.mycode.annotations;

import java.lang.reflect.Method;

/**
 * Created by abner on 7/22/15.
 */
public class AnnotationParseExample {

    public static void main(String[] args) {

        /**
         * parse the annotation whose Retention is RUNTIME
         */
        Class example = AnnotationUseExample.class;
        for(Method method : example.getMethods()){
            MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
            if(methodInfo != null){
                String author = methodInfo.author();
                String date = methodInfo.date();
                int version = methodInfo.version();

                System.out.println(author+"-"+date+"-"+version);
            }
        }

        System.out.println("s="+AnnotationUseExample.s);

    }
}
