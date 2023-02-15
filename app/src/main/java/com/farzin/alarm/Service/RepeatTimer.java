package com.farzin.alarm.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

public class RepeatTimer extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Date date = new Date();

        Log.e("Repeat timer", date.toString());
    }
}
