package com.farzin.alarm.Service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.farzin.alarm.MainActivity;
import com.farzin.alarm.R;

import java.util.Date;

public class AlarmsService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm Service", Toast.LENGTH_SHORT).show();


        //notifications
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        //اندروید 8 به بالا
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel channel = new NotificationChannel(context.getString(R.string.groups),
                    context.getString(R.string.app_name),NotificationManager.IMPORTANCE_DEFAULT);

            channel.setDescription("Hello");
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context,context.getString(R.string.groups));
        //set title
        notification.setContentTitle(context.getString(R.string.app_name));

        //set text
        notification.setContentText(new Date().toString());

        //set icon
        notification.setSmallIcon(R.drawable.alarm);

        //set Cancel
        notification.setAutoCancel(false);


        //set action
        Intent intent1 = new Intent(context.getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context.getApplicationContext(),1,intent1,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //set Vibration
        notification.setVibrate(new long[]{500,500,500,500});


        //set sound
        notification.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM));


        //notify , id = 1 is for one notification only
        notificationManager.notify(1,notification.build());


    }
}
