package com.gautams2.livedatawithroom.view.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gautams2.livedatawithroom.R;
import com.gautams2.livedatawithroom.databinding.ActivityMainBinding;
import com.gautams2.livedatawithroom.view.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        binding.setViewModel(viewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.getAllUser(this);
    }


}
