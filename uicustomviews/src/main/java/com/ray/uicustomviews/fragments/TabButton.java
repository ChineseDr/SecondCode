package com.ray.uicustomviews.fragments;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ray.uicustomviews.R;

public class TabButton extends LinearLayout {
    public TabButton(Context context) {
        super(context);
    }

    public TabButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TabButton);
        LayoutInflater.from(context).inflate(R.layout.tab_button,this);
        ImageView icon=findViewById(R.id.icon);
        icon.setImageResource(ta.getResourceId(R.styleable.TabButton_src,R.mipmap.home));
        TextView name=findViewById(R.id.name);
        name.setText(ta.getString(R.styleable.TabButton_text));
    }

    public TabButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
