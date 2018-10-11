package com.ray.component.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    //想要在程序没有启动的情况下，还能接收广播的话，那么就需要使用注册静态广播
    private static final String TAG = "MyBroadcastReceiver";
    private final String ACTION_BOOT="com.ray.component.broadcasts.MY_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: "+intent.getAction());
        if (ACTION_BOOT.equals(intent.getAction())){
            Toast.makeText(context,"接收到广播",Toast.LENGTH_SHORT).show();
        }
    }
}
