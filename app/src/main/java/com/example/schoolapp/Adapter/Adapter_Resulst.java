package com.example.schoolapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.schoolapp.Model.Resulst;
import com.example.schoolapp.R;

import java.util.ArrayList;

public class Adapter_Resulst extends RecyclerView.Adapter<Adapter_Resulst.ViewHolder_Resulst> {

    private Context context;
    ArrayList<Resulst> list;

    public Adapter_Resulst(Context context, ArrayList<Resulst> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder_Resulst onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_resulst, parent, false);
        return new ViewHolder_Resulst(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_Resulst holder, int position) {
        Resulst resulst = list.get(position);
        holder.tv_stt.setText(""+resulst.getStt());
        holder.tv_mhp.setText(resulst.getMhp());
        holder.tv_tenmon.setText(resulst.getTenmh());
        holder.tv_stc.setText(""+resulst.getSotc());
        holder.tv_diemcc.setText(""+resulst.getDiemcc());
        holder.tv_dhs1.setText(""+resulst.getDiemhs1());
        holder.tv_dhs2.setText(""+resulst.getDiemhs2());
        holder.tv_dhs3.setText(""+resulst.getDiemhs3());
        holder.tv_diemthi1.setText(""+resulst.getDiemck1());
        holder.tv_diemthi2.setText(""+resulst.getDiemck2());
        holder.tv_diemthi.setText(""+resulst.getDiemthi());
        holder.tv_diemtk.setText(""+resulst.getTongdiem());
        holder.tv_td4.setText(""+resulst.getTd4());
        holder.tv_diemchu.setText(resulst.getDiemchu());
        holder.tv_xeploai.setText(resulst.getXeploai());
        if (resulst.getImg() == 1){
            Glide.with(context).load(R.drawable.ok).into(holder.img);
        }else if (resulst.getImg() == 0){
            Glide.with(context).load(R.drawable.xoa).into(holder.img);
        }
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class ViewHolder_Resulst extends RecyclerView.ViewHolder {
        private TextView tv_stt,tv_mhp,tv_tenmon,tv_stc,tv_diemcc,tv_dhs1,tv_dhs2,
        tv_dhs3,tv_diemthi1,tv_diemthi2,tv_diemthi,tv_diemtk,tv_td4,tv_diemchu,tv_xeploai;
        private ImageView img;

        public ViewHolder_Resulst(@NonNull View v) {
            super(v);
            tv_stt = v.findViewById(R.id.tv_stt);
            tv_mhp = v.findViewById(R.id.tv_mhp);
            tv_tenmon = v.findViewById(R.id.tv_tenmon);
            tv_stc = v.findViewById(R.id.tv_stc);
            tv_diemcc = v.findViewById(R.id.tv_diemcc);
            tv_dhs1 = v.findViewById(R.id.tv_dhs1);
            tv_dhs2 = v.findViewById(R.id.tv_dhs2);
            tv_dhs3 = v.findViewById(R.id.tv_dhs3);
            tv_diemthi1 = v.findViewById(R.id.tv_diemthi1);
            tv_diemthi2 = v.findViewById(R.id.tv_diemthi2);
            tv_diemthi = v.findViewById(R.id.tv_diemthi);
            tv_diemtk = v.findViewById(R.id.tv_diemtk);
            tv_td4 = v.findViewById(R.id.tv_td4);
            tv_diemchu = v.findViewById(R.id.tv_diemchu);
            tv_xeploai = v.findViewById(R.id.tv_xeploai);
            img = v.findViewById(R.id.img);
        }
    }
}
