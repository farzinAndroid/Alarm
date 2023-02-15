package com.farzin.alarm.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.farzin.alarm.R;
import com.farzin.alarm.database.AppDatabase;
import com.farzin.alarm.databinding.AlarmRowBinding;
import com.farzin.alarm.model.Alarm;

import java.util.List;

public class AlarmAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<Alarm> alarmList;

    public AlarmAdapter(Context context, List<Alarm> alarmList) {
        this.context = context;
        this.alarmList = alarmList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        AlarmRowBinding alarmRowBinding = AlarmRowBinding.inflate(layoutInflater, parent, false);
        return new MyViewHolder(alarmRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.binding.hourTxt.setText(alarmList.get(position).getHour() + "");
        holder.binding.minuteTxt.setText(alarmList.get(position).getMinute() + "");


        holder.binding.deleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                        AppDatabase appDatabase = AppDatabase.getInstance(context);
                        appDatabase.getAlarmDAO().deleteAlarms(alarmList.get(holder.getAdapterPosition()));
                        alarmList.remove(holder.getAdapterPosition());
                        notifyItemRemoved(holder.getAdapterPosition());
                        notifyItemRangeChanged(holder.getAdapterPosition(),alarmList.size());


            }
        });


    }

    @Override
    public int getItemCount() {
        return alarmList.size();
    }
}
