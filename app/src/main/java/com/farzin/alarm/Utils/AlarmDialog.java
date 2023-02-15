package com.farzin.alarm.Utils;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TimePicker;

import androidx.appcompat.app.AlertDialog;

import com.farzin.alarm.R;
import com.farzin.alarm.database.AppDatabase;
import com.farzin.alarm.databinding.AlarmDialogBinding;
import com.farzin.alarm.model.Alarm;
import com.google.android.material.snackbar.Snackbar;

public class AlarmDialog {

    int hour = 0, min = 0;

    public void showAlarm(Activity activity) {

        AppDatabase appDatabase = AppDatabase.getInstance(activity);

        AlertDialog alertDialog = new AlertDialog.Builder(activity)
                .create();

        AlarmDialogBinding binding = AlarmDialogBinding.inflate(activity.getLayoutInflater());
        alertDialog.setView(binding.getRoot());
        binding.cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        binding.timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hourOfTheDay, int minute) {

                hour = hourOfTheDay;
                min = minute;
            }
        });

        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String alarm_Title = binding.alarmTitle.getText().toString();
                String alarm_description = binding.alarmDesc.getText().toString();


                if (alarm_Title.trim().equals("")) {
                    Snackbar.make(view, R.string.error_alarm, Snackbar.LENGTH_LONG)
                            .setTextColor(Color.WHITE)
                            .setAction(R.string.ok, v1 -> {

                            })
                            .setActionTextColor(Color.WHITE)
                            .show();
                } else {

                    AlarmUtils alarmUtils = new AlarmUtils();

                    Alarm alarm = new Alarm(hour, min, alarm_Title, alarm_description);
                   long result =  appDatabase.getAlarmDAO().insertAlarm(alarm);

                   //set Alarm
                    alarmUtils.setAlarm(activity, (int) result,hour,min);




                    Snackbar.make(view, R.string.alarm_added, Snackbar.LENGTH_LONG)
                            .setTextColor(Color.WHITE)
                            .setActionTextColor(Color.WHITE)
                            .show();
                }


            }
        });


        alertDialog.show();
    }
}
