package com.ray.uicustomviews.fragments;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ray.uicustomviews.R;
import com.ray.uicustomviews.broadcast.FirstBroadcast;

public class ContactFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        Button btn = view.findViewById(R.id.btn);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
