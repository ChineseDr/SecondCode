package com.ray.uicustomviews;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.ray.uicustomviews.viewPagers.MypagerAdapter;

import java.util.ArrayList;

public class ForthActivity extends Activity {
    private ViewPager vpager_one;
    private ArrayList<View> aList;
    private MypagerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_four);


        vpager_one = (ViewPager) findViewById(R.id.vpager_one);

        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.view_one,null,false));
        aList.add(li.inflate(R.layout.view_two,null,false));
        aList.add(li.inflate(R.layout.view_third,null,false));
        mAdapter = new MypagerAdapter(aList);
        vpager_one.setAdapter(mAdapter);
    }
}
