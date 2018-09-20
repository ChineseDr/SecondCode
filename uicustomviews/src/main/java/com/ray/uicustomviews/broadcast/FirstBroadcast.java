package com.ray.uicustomviews.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class FirstBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"FirstBroadcast" ,Toast.LENGTH_SHORT).show();

    }
}
