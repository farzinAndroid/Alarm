package com.farzin.alarm.Utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.farzin.alarm.Service.AlarmsService;

import java.util.Calendar;

public class AlarmUtils {

    public void setAlarm(Context context, int id, int hour, int minute) {

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent_alarm_service = new Intent(context, AlarmsService.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, id, intent_alarm_service, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);


        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

    }


}
