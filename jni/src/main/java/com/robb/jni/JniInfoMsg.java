package com.robb.jni;

/**
 * Created by robbs on 2016/8/7.
 * email:robbslu@gmail.com
 */
public class JniInfoMsg {
    static {
        System.loadLibrary("msg_jni");  //加载库
    }

    public native String getMsgFromJni(); //加载库方法

    public String getInfo() {
        return getMsgFromJni(); //进行java调用
    }
}
