package com.example.schoolapp.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolapp.Adapter.Adapter_Schedule;
import com.example.schoolapp.DAO.Schedule_DAO;
import com.example.schoolapp.Model.Schudeule;
import com.example.schoolapp.R;

import java.util.ArrayList;


public class Schedule_Fragment extends Fragment {

    private RecyclerView rcv_sl;
    private ArrayList<Schudeule> list;
    private Schedule_DAO schedule_dao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_schedule,container,false);
        addcontrol(view);
        return view;
    }

    // ánh xạ view
    private void addcontrol(View view) {
        rcv_sl = view.findViewById(R.id.rcv_sl);
        Loatlist();
        // Replace current fragment with ScheduleFragment and add it to the back stack
        // Replace current fragment with ScheduleFragment and add it to the back stac

    }


    private void Loatlist() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("User", Context.MODE_PRIVATE);
        int msv = sharedPreferences.getInt("msv",-1);
        schedule_dao = new Schedule_DAO(getContext());
        list = schedule_dao.getSchedule(msv);
        Log.e("List",String.valueOf(list));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcv_sl.setLayoutManager(linearLayoutManager);
        Adapter_Schedule adapter_schedule = new Adapter_Schedule(list,getContext());
        rcv_sl.setAdapter(adapter_schedule);
        // dòng kẻ của rcv
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rcv_sl.addItemDecoration(itemDecoration);
    }
}