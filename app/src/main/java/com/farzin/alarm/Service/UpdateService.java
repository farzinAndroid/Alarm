package com.farzin.alarm.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.farzin.alarm.BuildConfig;
import com.farzin.alarm.api.ApiCaller;
import com.farzin.alarm.api.MessageListener;
import com.farzin.alarm.model.Apps;

public class UpdateService extends Service {

    ApiCaller apiCaller;

    @Override
    public void onCreate() {
        apiCaller = new ApiCaller();
        super.onCreate();
        //start only once

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        apiCaller.getUpdate(new MessageListener() {
            @Override
            public void onSuccess(Object onSuccess) {
                Apps alarm = (Apps) onSuccess;
                int version = alarm.getVersion();

                //get version from android
                int appVersionCode = BuildConfig.VERSION_CODE;
                String appVersionName = BuildConfig.VERSION_NAME;

                if (appVersionCode < version){
                    Toast.makeText(getApplicationContext(), "Good", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Update App", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(String onError) {

            }
        });

        return START_STICKY;
    }



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
