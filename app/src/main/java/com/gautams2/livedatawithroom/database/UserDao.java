package com.gautams2.livedatawithroom.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * User Name: gautams2
 * Create Date : 11/17/2018
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertUser(User user);

    @Query("SELECT * FROM user")
    LiveData<List<User>> getUsers();

}
