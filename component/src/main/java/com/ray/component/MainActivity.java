package com.ray.component;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ray.component.broadcasts.DynamicBroadcastReceiver;

public class MainActivity extends Activity implements View.OnClickListener{
    DynamicBroadcastReceiver mReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_send=findViewById(R.id.send);
        Button btn_register=findViewById(R.id.register);
        Button btn_unregister=findViewById(R.id.unregister);
        Button btn_send_dynamic=findViewById(R.id.send_dynamic);
        btn_send.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        btn_send_dynamic.setOnClickListener(this);
        btn_unregister.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send:
                //从8.0开始静态自定义广播需要加入Component参数
                Intent intent1=new Intent("com.ray.component.broadcasts.MY_BROADCAST");
                intent1.setComponent(new ComponentName("com.ray.component","com.ray.component.broadcasts.MyBroadcastReceiver"));
                sendBroadcast(intent1);
                break;
            case R.id.register:
                //动态注册广播(绑定）
                mReceiver=new DynamicBroadcastReceiver();
                //关键
                IntentFilter filter=new IntentFilter();
                filter.addAction("com.ray.component.broadcasts.DY_BROADCAST");
                filter.setPriority(100);//设置接收器的优先级
                registerReceiver(mReceiver,filter);
                break;
            case R.id.unregister:
                //解绑动态广播
                unregisterReceiver(mReceiver);
            case R.id.send_dynamic:
                //发送广播，发送广播前需要先定义一个广播接收器（DynamicBroadcastReceiver，并注册）
                Intent intent2=new Intent("com.ray.component.broadcasts.DY_BROADCAST");
                sendBroadcast(intent2);//发送标准广播
                sendBroadcast(intent2,null);//发送有序广播
                break;

        }
    }
}
