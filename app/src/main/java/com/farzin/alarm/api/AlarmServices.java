package com.farzin.alarm.api;

import com.farzin.alarm.model.Apps;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlarmServices {

    @GET("getCurrentVersion.php")
    Call<Apps> getUpdate();
}
