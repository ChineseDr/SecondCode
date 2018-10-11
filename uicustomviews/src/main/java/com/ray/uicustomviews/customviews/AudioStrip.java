package com.ray.uicustomviews.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class AudioStrip extends View {
    private static final String TAG = "AudioStrip";
    private int mWidth;//View的宽
    private int mRectWidth;//矩形的宽
    private int mRectHeight;//矩形的高
    private Paint mPaint;//
    private int mRectCount;//矩形数量
    private double mRandom;//随机数
    private int offset = 5;
    private LinearGradient mLinearGradient;//线性渐变效果

    public AudioStrip(Context context) {
        super(context);
    }

    public AudioStrip(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
        mRectCount = 12;
    }

    public AudioStrip(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mRectCount; i++) {
            mRandom = Math.random();//获取随机数
//            if (mRandom>10){
//                mRandom=mRandom%10;
//            }
            float currentHeight = (float) (mRectHeight * mRandom);//当前矩形高度
            //绘制矩形
            canvas.drawRect(
                    (float) (mWidth * 0.4 / 2 + mRectWidth * i + offset), currentHeight,
                    (float) (mWidth * 0.4 / 2 + mRectWidth * (i + 1)), mRectHeight, mPaint);
            Log.d(TAG, "onDraw:currentHeight: "+currentHeight+" width1: "+(mWidth * 0.4 / 2 + mRectWidth * i + offset)+
            " width2: "+mWidth * 0.4 / 2 + mRectWidth * (i + 1));
        }
        Log.d(TAG, "onDraw:mRandom "+mRandom);
        postInvalidateDelayed(300);//每隔300毫秒通知onDraw进行View重绘
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        mRectHeight = getHeight();
        mRectWidth = (int) (mWidth * 0.6 / mRectCount);
        Log.d(TAG, "onSizeChanged:mWidth "+mWidth+" mRectHeight: "+mRectHeight);
        mLinearGradient = new LinearGradient(0, 0, mRectWidth, mRectHeight,
                Color.YELLOW, Color.BLUE, Shader.TileMode.CLAMP);//
        mPaint.setShader(mLinearGradient);//
    }
}
