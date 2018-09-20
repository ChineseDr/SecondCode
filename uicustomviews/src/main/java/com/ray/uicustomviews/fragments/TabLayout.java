package com.ray.uicustomviews.fragments;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.ray.uicustomviews.R;

public class TabLayout extends LinearLayout {
    public TabLayout(Context context) {
        super(context);
    }

    public TabLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public TabLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.tab,this);
        TabButton hbtn=findViewById(R.id.hbtn);
    }


}
