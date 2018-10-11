package com.ray.component.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DynamicBroadcastReceiver extends BroadcastReceiver {
    //动态注册有个缺点就是需要程序启动才可以接收广播
    private final String ACTION_BOOT="com.ray.component.broadcasts.DY_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION_BOOT.equals(intent.getAction())){
            Toast.makeText(context,"接收到一条动态广播",Toast.LENGTH_SHORT).show();
        }
    }
}
