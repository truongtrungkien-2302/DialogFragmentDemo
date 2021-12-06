package com.android45.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android45.dialogfragment.databinding.ActivityLoginFragmentBinding;

public class LoginFragment extends AppCompatActivity {
    ActivityLoginFragmentBinding activityLoginFragmentBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_fragment);

        activityLoginFragmentBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_fragment);

        activityLoginFragmentBinding.btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FragmentActivity.class);
                startActivity(intent);
            }
        });
    }
}