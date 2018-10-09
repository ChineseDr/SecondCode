package com.ray.uicustomviews.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ray.uicustomviews.R;
import com.ray.uicustomviews.customviews.CircleView;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_first,container,false);
        CircleView circleView=view.findViewById(R.id.circle_process);
        circleView.setSweepValue(90);
        return view;
    }
}
