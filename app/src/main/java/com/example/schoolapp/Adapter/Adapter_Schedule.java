package com.example.schoolapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolapp.Model.Schudeule;
import com.example.schoolapp.R;

import java.util.ArrayList;

public class Adapter_Schedule extends RecyclerView.Adapter<Adapter_Schedule.ViewHolder_Schedule> {
    private ArrayList<Schudeule> list;
    private Context context;

    public Adapter_Schedule(ArrayList<Schudeule> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder_Schedule onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.iteam_schedule,parent,false);
        return new ViewHolder_Schedule(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_Schedule holder, int position) {
        Schudeule schudeule = list.get(position);
        holder.tv_monh.setText("môn hoc: "+schudeule.getTenmon());
        holder.tv_mamh.setText("mamh: "+schudeule.getMamh());
        holder.tv_tiet.setText("tiết: "+schudeule.getTiet());
        holder.tv_room.setText("room: "+schudeule.getPhong());
        holder.tv_gv.setText("GV: "+schudeule.getGV());
        holder.tv_gio.setText("Giơ: "+schudeule.getGio());

    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class ViewHolder_Schedule extends RecyclerView.ViewHolder {
        private TextView tv_monh, tv_mamh, tv_tiet, tv_gio, tv_room, tv_gv;

        public ViewHolder_Schedule(@NonNull View v) {
            super(v);
            tv_monh = v.findViewById(R.id.tv_monh);
            tv_mamh = v.findViewById(R.id.tv_mamh);
            tv_tiet = v.findViewById(R.id.tv_tiet);
            tv_gio = v.findViewById(R.id.tv_gio);
            tv_room = v.findViewById(R.id.tv_room);
            tv_gv = v.findViewById(R.id.tv_gv);
        }
    }
}
