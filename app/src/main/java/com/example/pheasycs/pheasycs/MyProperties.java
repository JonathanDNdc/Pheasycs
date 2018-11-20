package com.example.pheasycs.pheasycs;

public class MyProperties {
    private static MyProperties mInstance= null;

    public int fragmentValue = -1;

    protected MyProperties(){}

    public static synchronized MyProperties getInstance() {
        if(null == mInstance){
            mInstance = new MyProperties();
        }
        return mInstance;
    }
}