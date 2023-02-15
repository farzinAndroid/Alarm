package com.farzin.alarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import com.farzin.alarm.Service.RepeatTimer;
import com.farzin.alarm.Service.UpdateService;
import com.farzin.alarm.Utils.AlarmDialog;
import com.farzin.alarm.adapter.AlarmAdapter;
import com.farzin.alarm.database.AppDatabase;
import com.farzin.alarm.databinding.ActivityMainBinding;
import com.farzin.alarm.model.Alarm;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AlarmDialog alarmDialog;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startBinding();
        setSupportActionBar(binding.toolbar);
        alarmDialog = new AlarmDialog();
        appDatabase = AppDatabase.getInstance(this);


        binding.addAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alarmDialog.showAlarm(MainActivity.this);
            }
        });

        //load all alarms
        loadAlarms();


























        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent timer_intent = new Intent(getApplicationContext(), RepeatTimer.class);

        //connect it to alarm Manager
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 1, timer_intent, 0);
        Calendar calendar = Calendar.getInstance();
        //set repeating
        //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 60000, pendingIntent);




        //second example

        AlarmManager alarmManager1 = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent_exact = new Intent(this,RepeatTimer.class);

        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(getApplicationContext(),2,intent_exact,0);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(System.currentTimeMillis());
        calendar1.set(Calendar.HOUR_OF_DAY,12);
        calendar1.set(Calendar.MINUTE,20);
        alarmManager1.setRepeating(AlarmManager.RTC_WAKEUP,calendar1.getTimeInMillis(),60000,pendingIntent1);

    }


    private void loadAlarms() {
        List<Alarm> alarms = appDatabase.getAlarmDAO().getAllAlarms();

        binding.rv.setAdapter(new AlarmAdapter(getApplicationContext(),alarms));
        binding.rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        binding.rv.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
    }

    private void startBinding() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}