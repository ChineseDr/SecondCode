package com.ray.uicustomviews.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class MyScrollView extends ViewGroup {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        
    }
}
