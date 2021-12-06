package com.android45.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;

import com.android45.dialogfragment.databinding.ActivityAddBinding;
import com.android45.dialogfragment.databinding.ActivityMainBinding;

public class AddActivity extends AppCompatActivity {
    ActivityAddBinding activityAddBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        activityAddBinding = DataBindingUtil.setContentView(this, R.layout.activity_add);

//activityAddBinding.rvMenu
    }
}