package com.example.schoolapp.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolapp.Listenner.Lintenner_class;
import com.example.schoolapp.Model.Class;
import com.example.schoolapp.Model.Sinhvien;
import com.example.schoolapp.R;

import java.util.ArrayList;

public class Adapter_Class extends RecyclerView.Adapter<Adapter_Class.ViewHolder_Class> {
    private ArrayList<Class> list;
    private Context context;
    private Lintenner_class lintenner_class;

    public Adapter_Class(ArrayList<Class> list, Context context,Lintenner_class lintenner_class) {
        this.list = list;
        this.context = context;
        this.lintenner_class = lintenner_class;
    }

    @NonNull
    @Override
    public ViewHolder_Class onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.iteam_class,parent,false);

        return new ViewHolder_Class(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_Class holder, int position) {
        Class aClass = list.get(position);
        holder.tv_class.setText(aClass.getTenlop());
        //Log.e("tvclass",holder.tv_class.getText().toString());
        holder.layout_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lintenner_class.Click_Class(aClass);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class ViewHolder_Class extends RecyclerView.ViewHolder{
        public TextView tv_class;
        private LinearLayout layout_class;

        public ViewHolder_Class(@NonNull View itemView) {
            super(itemView);
           tv_class = itemView.findViewById(R.id.tv_class);
           layout_class = itemView.findViewById(R.id.layoutclass);
        }
    }
}
