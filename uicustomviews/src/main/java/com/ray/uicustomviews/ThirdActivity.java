package com.ray.uicustomviews;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ray.uicustomviews.broadcast.FirstBroadcast;
import com.ray.uicustomviews.fragments.ContactFragment;
import com.ray.uicustomviews.fragments.HomeFragment;
import com.ray.uicustomviews.fragments.TabButton;

public class ThirdActivity extends AppCompatActivity {
    HomeFragment homeFragment=new HomeFragment();
    private IntentFilter intentFilter;
    private FirstBroadcast firstBroadcast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }

        TitleLayout titleLayout=findViewById(R.id.third_title);
        titleLayout.setListener(new TitleLayout.TitleClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });



        TabButton hbtn=findViewById(R.id.hbtn);
        TabButton cbtn=findViewById(R.id.cbtn);
        TabButton fbtn=findViewById(R.id.fbtn);
        TabButton mbtn=findViewById(R.id.mbtn);
        hbtn.setOnClickListener(mListener);
        cbtn.setOnClickListener(mListener);
        fbtn.setOnClickListener(mListener);
        mbtn.setOnClickListener(mListener);

        placeFragment(homeFragment);

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        firstBroadcast = new FirstBroadcast();
        registerReceiver(firstBroadcast,intentFilter);

    }


    private View.OnClickListener mListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.hbtn:
                    placeFragment(homeFragment);
                    break;
                case R.id.cbtn:
                    placeFragment(new ContactFragment());
                    break;
                case R.id.fbtn:
                    placeFragment(new HomeFragment());
                    break;
                case R.id.mbtn:
                    placeFragment(new ContactFragment());
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
        transaction.replace(R.id.content,fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(firstBroadcast);
    }

    class NetworkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"FirstBroadcast" ,Toast.LENGTH_SHORT).show();
        }
    }
}
