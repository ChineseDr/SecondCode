package com.ray.uicustomviews;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.ray.uicustomviews.broadcast.FirstBroadcast;
import com.ray.uicustomviews.fragments.ContactFragment;
import com.ray.uicustomviews.fragments.HomeFragment;
import com.ray.uicustomviews.fragments.TabButton;
import com.ray.uicustomviews.viewPagers.MyFragmentPagerAdapter;

public class ThirdActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    HomeFragment homeFragment=new HomeFragment();
    private Intent intent;
    private FirstBroadcast firstBroadcast;

    private ViewPager viewPager;
    private MyFragmentPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }

        mAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager());

        TitleLayout titleLayout=findViewById(R.id.third_title);
        titleLayout.setListener(new TitleLayout.TitleClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {
                Toast.makeText(ThirdActivity.this,"onclick" ,Toast.LENGTH_SHORT).show();
                intent = new Intent("com.ray.uicustomviews.broadcast.FIRSTBROADCAST");
                sendBroadcast(intent);
            }
        });

        viewPager=findViewById(R.id.content_view);

        TabButton hbtn=findViewById(R.id.hbtn);
        TabButton cbtn=findViewById(R.id.cbtn);
        TabButton fbtn=findViewById(R.id.fbtn);
        TabButton mbtn=findViewById(R.id.mbtn);
        hbtn.setOnClickListener(mListener);
        cbtn.setOnClickListener(mListener);
        fbtn.setOnClickListener(mListener);
        mbtn.setOnClickListener(mListener);

        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(PAGE_ONE);

        viewPager.addOnPageChangeListener(this);


    }


    private View.OnClickListener mListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.hbtn:
                    //placeFragment(homeFragment);
                    viewPager.setCurrentItem(PAGE_ONE);
                    break;
                case R.id.cbtn:
                    //placeFragment(new ContactFragment());
                    viewPager.setCurrentItem(PAGE_TWO);
                    break;
                case R.id.fbtn:
//                    placeFragment(new HomeFragment());
                    viewPager.setCurrentItem(PAGE_THREE);
                    break;
                case R.id.mbtn:
//                    placeFragment(new ContactFragment());
                    viewPager.setCurrentItem(PAGE_FOUR);
                    break;
                    default:

                        break;
            }
        }
    };

    private void placeFragment(Fragment fragment){
        //支持包调用getSupportFragmentManager
        FragmentManager manager=getSupportFragmentManager();
        //调用beginTransaction开启事务
        FragmentTransaction transaction=manager.beginTransaction();
        //向控件添加或替换Fragment
        //transaction.replace(R.id.content,fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unregisterReceiver(firstBroadcast);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class NetworkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"FirstBroadcast" ,Toast.LENGTH_SHORT).show();
        }
    }
}
