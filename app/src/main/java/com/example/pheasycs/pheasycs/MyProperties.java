package com.example.pheasycs.pheasycs;

// This class is for the global variable that we will use to
// set the layouts of the formulas fragment.

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