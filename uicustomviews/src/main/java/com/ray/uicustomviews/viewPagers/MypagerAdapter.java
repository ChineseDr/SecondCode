package com.ray.uicustomviews.viewPagers;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MypagerAdapter extends PagerAdapter {

    private ArrayList<View> viewLists;

    public MypagerAdapter() {
    }

    public MypagerAdapter(ArrayList<View> viewLists) {
        this.viewLists = viewLists;
    }

    /**
     * 获取Viewpager中有多少view
     * @return
     */
    @Override
    public int getCount() {
        return viewLists.size();
    }

    /**
     * 判断instantiateItem(ViewGroup, int)函数所返回来的Key与一个页面视图是否是代表的同一个视图
     * @param view
     * @param object
     * @return 返回 view == object
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view==object;
    }


    /**
     * 将指定位置的view添加到容器
     * 返回代表新增页面的Object
     * @param container
     * @param position
     * @return
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(viewLists.get(position));
        return viewLists.get(position);
    }

    /**
     * 移除指定位置的页面
     * @param container
     * @param position 指定位置
     * @param object
     */
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(viewLists.get(position));
    }
}
