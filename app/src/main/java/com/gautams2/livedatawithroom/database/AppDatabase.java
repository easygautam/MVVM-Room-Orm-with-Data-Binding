package com.gautams2.livedatawithroom.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.gautams2.livedatawithroom.database.User;

/**
 * User Name: gautams2
 * Create Date : 11/17/2018
 */
@Database(entities = {
        User.class
}, version = AppDatabase.VERSION)
public abstract class AppDatabase extends RoomDatabase {
    public static final int VERSION = 1;
    private static final String NAME = "_app_database";


    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context){
        if (instance != null) return instance;
        return instance = Room.databaseBuilder(context, AppDatabase.class, AppDatabase.NAME).build();
    }

    public abstract UserDao userDao();

}
