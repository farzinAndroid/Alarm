package com.farzin.alarm.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class BootupReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Broadcast", Toast.LENGTH_SHORT).show();

        Intent intent_update = new Intent(context.getApplicationContext(), UpdateService.class);


        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            ContextCompat.startForegroundService(context, intent_update);
        }else {
            context.startService(intent_update);
        }

    }
}
