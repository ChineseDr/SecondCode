package com.ray.uicustomviews.viewPagers;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.ray.uicustomviews.ThirdActivity;
import com.ray.uicustomviews.fragments.ContactFragment;
import com.ray.uicustomviews.fragments.FoundFragment;
import com.ray.uicustomviews.fragments.HomeFragment;
import com.ray.uicustomviews.fragments.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list = new ArrayList<>();
    private HomeFragment home = null;
    private ContactFragment contact = null;
    private FoundFragment found = null;
    private MineFragment mine = null;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        home = new HomeFragment();
        contact = new ContactFragment();
        found = new FoundFragment();
        mine = new MineFragment();
        list.add(home);
        list.add(contact);
        list.add(found);
        list.add(mine);
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case ThirdActivity.PAGE_ONE:
                fragment=home;
                break;
            case ThirdActivity.PAGE_TWO:
                fragment=contact;
                break;
            case ThirdActivity.PAGE_THREE:
                fragment=found;
                break;
            case ThirdActivity.PAGE_FOUR:
                fragment=mine;
                break;
            default:
                fragment=new HomeFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return super.isViewFromObject(view, object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
