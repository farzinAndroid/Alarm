package com.farzin.alarm.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.farzin.alarm.model.Alarm;

import java.util.List;

@Dao
public interface AlarmDAO {


    @Insert
    public Long insertAlarm(Alarm alarms);

    @Delete
    void deleteAlarms(Alarm alarm);

    @Query("select * from tbl_alarm")
    public List<Alarm> getAllAlarms();
}
