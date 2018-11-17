package com.gautams2.livedatawithroom.view.viewmodel;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import com.gautams2.livedatawithroom.MyApplication;
import com.gautams2.livedatawithroom.database.AppDatabase;
import com.gautams2.livedatawithroom.database.User;
import com.gautams2.livedatawithroom.database.UserDao;

/**
 * User Name: gautams2
 * Create Date : 11/17/2018
 */
public class MainActivityViewModel extends ViewModel {

    private final String TAG = getClass().getSimpleName();

    private ObservableField<String> userName = new ObservableField<>();
    private ObservableField<String> usersDetails = new ObservableField<>();

    private UserDao userDao;

    public MainActivityViewModel() {
        userDao = MyApplication.appDatabase.userDao();
    }

    public View.OnClickListener onUserAddClick() {
        return view -> {
            User user = new User();
            user.setUserName(userName.get());
            new Thread(()->{
                Long id = userDao.insertUser(user);
                Log.d(TAG, "onUserAddClick: User inserted - " + id);
            }) .start();
        };
    }

    public void getAllUser(LifecycleOwner lifecycleOwner) {
        userDao.getUsers().observe(lifecycleOwner, users -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (User user :
                    users) {

                      stringBuilder.append("Id - " + user.getId());
                      stringBuilder.append(", Name - " + user.getUserName());
                      stringBuilder.append("\n\n");
            }
            usersDetails.set(stringBuilder.toString());
        });
    }

    public ObservableField<String> getUserName() {
        return userName;
    }

    public void setUserName(ObservableField<String> userName) {
        this.userName = userName;
    }

    public ObservableField<String> getUsersDetails() {
        return usersDetails;
    }

    public void setUsersDetails(ObservableField<String> usersDetails) {
        this.usersDetails = usersDetails;
    }
}
