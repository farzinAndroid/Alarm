package com.farzin.alarm.api;

import com.farzin.alarm.model.Apps;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCaller {

    AlarmServices alarmServices;
    public ApiCaller() {

        alarmServices = ApiClient.retrofit().create(AlarmServices.class);
    }


    public void getUpdate(MessageListener messageListener){
        Call<Apps> call = alarmServices.getUpdate();
        call.enqueue(new Callback<Apps>() {
            @Override
            public void onResponse(Call<Apps> call, Response<Apps> response) {
                messageListener.onSuccess(response);
            }

            @Override
            public void onFailure(Call<Apps> call, Throwable t) {
                messageListener.onFailure(t.getMessage());
            }
        });
    }
}
