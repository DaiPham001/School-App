package com.example.schoolapp.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolapp.Model.Sinhvien;
import com.example.schoolapp.R;

import java.util.ArrayList;

public class Adapter_user extends RecyclerView.Adapter<Adapter_user.ViewHolder_user> {

    private ArrayList<Sinhvien> list;
    private Context context;

    public Adapter_user(ArrayList<Sinhvien> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder_user onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user,parent,false);
        return new ViewHolder_user(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_user holder, int position) {
        Sinhvien sinhvien = list.get(position);
        holder.tv_id.setText("Thứ tự: " +sinhvien.getId());
        Log.e("svid","id: "+holder.tv_id.getText().toString());
        holder.tv_msv.setText("Mã sinh viên: " + sinhvien.getMsv());
        holder.tv_name.setText("Tên: " + sinhvien.getName());

    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class ViewHolder_user extends RecyclerView.ViewHolder{
        private TextView tv_id,tv_msv,tv_name;

        public ViewHolder_user(@NonNull View view) {
            super(view);
            tv_id = view.findViewById(R.id.tv_iduser);
            tv_msv = view.findViewById(R.id.tv_msv);
            tv_name = view.findViewById(R.id.tv_name);
        }
    }
}
