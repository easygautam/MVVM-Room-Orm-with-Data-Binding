package com.gautams2.livedatawithroom.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * User Name: gautams2
 * Create Date : 11/17/2018
 */
@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
