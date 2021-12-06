package com.android45.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android45.dialogfragment.databinding.ActivityFragmentBinding;

public class FragmentActivity extends AppCompatActivity {
    ActivityFragmentBinding activityFragmentBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        activityFragmentBinding = DataBindingUtil.setContentView(this, R.layout.activity_fragment);

        activityFragmentBinding.tvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(HomeFragment.newInstance());
            }
        });

        activityFragmentBinding.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(AddFragment.newInstance());
            }
        });

        activityFragmentBinding.tvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(DetailFragment.newInstance());
            }
        });
    }

    private void getFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentID, fragment).commit();
    }
}