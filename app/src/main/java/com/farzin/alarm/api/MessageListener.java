package com.farzin.alarm.api;

public interface MessageListener<T>{

    public void onSuccess(T onSuccess);
    public void onFailure(String onError);
}
