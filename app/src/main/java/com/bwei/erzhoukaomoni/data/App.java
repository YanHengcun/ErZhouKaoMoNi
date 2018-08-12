package com.bwei.erzhoukaomoni.data;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by Jack Lee on 2018/8/11.
 * name:Juck Lee
 */

public class App extends Application {
    private static App app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
       
    }
    public static App getInstance(){

        return app;
    }
}
