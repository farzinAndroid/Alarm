package com.farzin.alarm.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.farzin.alarm.model.Alarm;
import com.farzin.alarm.model.Constants;

@Database(entities = {Alarm.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance = null;

    public abstract AlarmDAO getAlarmDAO();

    public static synchronized AppDatabase getInstance(Context context){

        if (instance == null){

            instance = Room.databaseBuilder(context,AppDatabase.class, Constants.DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
