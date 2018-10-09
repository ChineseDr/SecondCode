package com.ray.uicustomviews.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class AudioStrip extends View {
    private int mWidth;//View的宽
    private int mRectWidth;//矩形的宽
    private int mRectHeight;//矩形的高
    private Paint mPaint;//
    private int mRectCount;
    public AudioStrip(Context context) {
        super(context);
    }

    public AudioStrip(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AudioStrip(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
