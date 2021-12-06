package com.android45.dialogfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.android45.dialogfragment.databinding.DetailFragmentBinding;
import com.android45.dialogfragment.databinding.HomeFragmentBinding;

public class DetailFragment extends Fragment {
    DetailFragmentBinding detailFragmentBinding;

    public static DetailFragment newInstance() {

        Bundle args = new Bundle();

        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        detailFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false);
        return detailFragmentBinding.getRoot();
    }
}
