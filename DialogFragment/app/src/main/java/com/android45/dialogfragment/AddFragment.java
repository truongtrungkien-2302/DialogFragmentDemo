package com.android45.dialogfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.android45.dialogfragment.databinding.AddFragmentBinding;
import com.android45.dialogfragment.databinding.HomeFragmentBinding;

public class AddFragment extends Fragment {
    AddFragmentBinding addFragmentBinding;

    public static AddFragment newInstance() {

        Bundle args = new Bundle();

        AddFragment fragment = new AddFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        addFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.add_fragment, container, false);
        return addFragmentBinding.getRoot();
    }
}
