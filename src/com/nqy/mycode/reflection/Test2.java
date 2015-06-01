package com.nqy.mycode.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abner on 5/29/15.
 */
public class Test2 {
    private String p;

    @MyAnnotation(key="k2",value = "v2")
    private void say2(){
        System.out.println("i am say2 in Test2");
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
    public @interface MyAnnotation{
        public String value();
        public String key();
    }

    public void sayPublic(@MyAnnotation(key="kp",value = "vp") String s,@MyAnnotation(key="ki",value = "vi") int i){
        System.out.println("i am sayPublic in Test2 "+s);
    }

    protected List<String> stringList = new ArrayList<String>();

    public List<String> getStringList(){
        return this.stringList;
    }
}
