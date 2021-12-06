package com.android45.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android45.dialogfragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.tvName.setText("Truong Trung Kien");
        activityMainBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddActivity.class);
                startActivity(intent);
            }
        });
    }
}