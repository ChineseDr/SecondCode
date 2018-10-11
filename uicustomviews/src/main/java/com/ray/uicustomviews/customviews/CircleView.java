package com.ray.uicustomviews.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

public class CircleView extends View {
    private static final String TAG = "CircleView";

    private Paint mCirPaint;//中间画圆画笔
    private Paint mArcPaint;//外圈画弧画笔
    private Paint mTextPaint;//内部文字画笔

    private float mCircleXY;
    private float mRadius;
    private int length;
    private int mTextSize=100;
    private int mSweepAngle=0;
    private String mTextShow="Android";
    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        WindowManager manager= (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);

//        此方法已经废弃
//        length=manager.getDefaultDisplay().getWidth();
//        替代方案，获取屏幕宽度
        DisplayMetrics dm=new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        length=dm.widthPixels;

        mCircleXY=length/2;//圆心
        mRadius= (float) (length*0.5/2);//半径

        mCirPaint=new Paint();
        mCirPaint.setColor(Color.RED);

        mArcPaint=new Paint();
        mArcPaint.setStrokeWidth(60);//
        mArcPaint.setStyle(Paint.Style.FILL_AND_STROKE);//STROKE描边，FILL填充
        mArcPaint.setColor(Color.BLUE);

        mTextPaint=new Paint();
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);//文字的对齐方式
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * 绘制内部圆形
         * 第一、二个参数：圆心坐标（x，y）
         * 第三个参数：半径
         * 第四个参数：画笔
         */
        canvas.drawCircle(mCircleXY,mCircleXY,mRadius,mCirPaint);

        //绘制弧线，指定其外接矩形
        RectF mArcRectF=new RectF(
                (float)(length*0.1),
                (float)(length*0.1),
                (float)(length*0.9),
                (float)(length*0.9));
        /**
         * 第一个参数：要绘制的弧线椭圆的外接矩形
         * 第二个参数：画弧开始的角度，0：三点钟位置；90:六点钟位置；180:九点钟位置；270:零点位置
         * 第三个参数：画弧结束的角度，顺时针方向
         * 第四个参数：
         * 第五个参数：画笔
         */
        canvas.drawArc(mArcRectF,180,mSweepAngle,true,mArcPaint);

        /**
         * 第一个参数：显示的文本内容
         * 第二个参数：开始显示的位置，文本的第几个字符开始显示
         * 第三个参数：显示结束的位置，文本长度（第几个字符结束）
         * 第四个参数：文本显示的x轴位置，中心点x周坐标，默认在字符串左边
         * 第五个参数：文本显示的y轴位置，中心点y周坐标,默认在字符串下方,
         * 设置center时，实际位置在指定位置上方1/4 size处
         * 第六个采纳数：画笔
         */
        canvas.drawText(mTextShow,0,mTextShow.length(),mCircleXY,mCircleXY+(mTextSize/4),mTextPaint);
        Log.d(TAG, "onDraw: drawText"+mCircleXY+(mTextSize));
    }

    public void setSweepValue(int sweepValue){
        if (sweepValue!=0){
            mSweepAngle=sweepValue;
        }else {
            mSweepAngle=0;
        }
        //刷新，重新绘制
        invalidate();
    }

    public void setText(String text){
        if (!text.equals("")){
            mTextShow=text;
        }else {
            mTextShow="Android";
        }
        invalidate();
    }
}
