package com.nqy.mycode.annotations;

/**
 * Created by abner on 7/23/15.
 */
public class MyClass {
    @Deprecated
    /**
     * @deprecated Use getMyNameNew instead
     */
    public void getMyName(){

    }

    public void getMyNameNew(@ParamInfo(version = 2)String name){

    }
}
