package com.example.schoolapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolapp.Listenner.Listenner_mj;
import com.example.schoolapp.Model.Majors;
import com.example.schoolapp.R;

import java.util.ArrayList;

public class Adapter_Majors extends RecyclerView.Adapter<Adapter_Majors.ViewHorder_mj> {
    private ArrayList<Majors> list;
    private Context context;
    private Listenner_mj listenner_mj;
    private FragmentManager fragmentManager;

    public Adapter_Majors(ArrayList<Majors> list, Context context, Listenner_mj listenner_mj) {
        this.list = list;
        this.context = context;
       this.listenner_mj = listenner_mj;
    }

    @NonNull
    @Override
    public ViewHorder_mj onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_majors, parent, false);

        return new ViewHorder_mj(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHorder_mj holder, int position) {
        Majors majors = list.get(position);
        holder.tv_mang.setText("Mã ngành: "+majors.getManganh());
        holder.tv_nganh.setText("Tên ngành: "+majors.getNganh());
       holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenner_mj.Click_Majors(majors);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class ViewHorder_mj extends RecyclerView.ViewHolder {

        private TextView tv_mang;
        private TextView tv_nganh;
        private LinearLayout linearLayout;

        public ViewHorder_mj(@NonNull View itemView) {
            super(itemView);
            tv_mang = itemView.findViewById(R.id.tv_mang);
            tv_nganh = itemView.findViewById(R.id.tv_nganh);
            linearLayout = itemView.findViewById(R.id.layout_mj);
        }
    }
}
