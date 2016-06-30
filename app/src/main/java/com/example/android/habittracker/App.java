package com.example.android.habittracker;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by goransi on 30.6.2016..
 */
public class App extends Application {


    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
