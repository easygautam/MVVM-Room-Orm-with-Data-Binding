package com.gautams2.livedatawithroom;

import android.app.Application;

import com.gautams2.livedatawithroom.database.AppDatabase;

/**
 * User Name: gautams2
 * Create Date : 11/17/2018
 */
public class MyApplication extends Application {

    public static AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        appDatabase = AppDatabase.getInstance(this);
    }
}
