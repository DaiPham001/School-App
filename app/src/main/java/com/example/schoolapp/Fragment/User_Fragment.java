package com.example.schoolapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.schoolapp.Adapter.Adapter_user;
import com.example.schoolapp.DAO.Sinhvien_DAO;
import com.example.schoolapp.Model.Sinhvien;
import com.example.schoolapp.R;

import java.util.ArrayList;


public class User_Fragment extends Fragment {

    private RecyclerView rcv_user;
    private ArrayList<Sinhvien> list;
    private Sinhvien_DAO sinhvien_dao;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_user, container, false);
        addcontroll(view);
        return view;
    }

    // ánh xạ view
    private void addcontroll(View view) {
        rcv_user = view.findViewById(R.id.rcv_user);
        Loadlist();
    }

    private void Loadlist() {
        // nhận dữ liệu từ class_fragment
        String tenlop = getArguments().getString("tenlop");
        sinhvien_dao = new Sinhvien_DAO(getContext());
        list = sinhvien_dao.listsinhvien(tenlop);
        if (list != null){
            // Log.e("list", String.valueOf(list));
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            rcv_user.setLayoutManager(linearLayoutManager);
            Adapter_user adapter_user = new Adapter_user(list, getContext());
            rcv_user.setAdapter(adapter_user);

            // dòng kẻ của rcv
            RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
            rcv_user.addItemDecoration(itemDecoration);
        }else {
            Log.e("list","null");
        }


    }
}