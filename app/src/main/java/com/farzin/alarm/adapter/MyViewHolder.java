package com.farzin.alarm.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.farzin.alarm.databinding.AlarmRowBinding;

public class MyViewHolder extends RecyclerView.ViewHolder {

    AlarmRowBinding binding;

    public MyViewHolder(AlarmRowBinding alarmRowBinding) {
        super(alarmRowBinding.getRoot());
        this.binding = alarmRowBinding;
    }
}
