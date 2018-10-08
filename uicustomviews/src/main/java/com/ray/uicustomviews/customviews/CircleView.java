package com.ray.uicustomviews.customviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class CircleView extends View {

    private float mCircleXY;
    private float mRadius;
    private int length;
    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        WindowManager manager= (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);

//        此方法已经废弃
//        length=manager.getDefaultDisplay().getWidth();
//        替代方案
        DisplayMetrics dm=new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        length=dm.widthPixels;

    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
