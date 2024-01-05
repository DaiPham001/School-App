package com.example.schoolapp.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolapp.Adapter.Adapter_Resulst;
import com.example.schoolapp.DAO.Sinhvien_DAO;
import com.example.schoolapp.Model.Resulst;
import com.example.schoolapp.R;

import java.util.ArrayList;
import java.util.List;

public class Results_Fragment extends Fragment {
    //TextView tv1_diemcc, tv_diemhs1, tv_diemhs2,tv_diemhs3,tv_diemck1,tv_diemck2,tv_tongdiem;
    private RecyclerView rcv_rs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results_, container, false);
        addcontroll(view);

        addevenst();
        return view;
    }

    // ánh xạ view
    private void addcontroll(View view) {
        rcv_rs = view.findViewById(R.id.rcv_rs);
        Loadlist();
    }

    // xử lý sự kiện
    private void addevenst() {
    }

    private void Loadlist() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        int msv = sharedPreferences.getInt("msv",-1);

        Sinhvien_DAO sinhvien_dao = new Sinhvien_DAO(getContext());

        ArrayList<Resulst> listl = sinhvien_dao.getResults(msv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcv_rs.setLayoutManager(linearLayoutManager);

        //Log.e("list", String.valueOf(listl));
        Adapter_Resulst adapter_resulst = new Adapter_Resulst(getContext(),listl);
        rcv_rs.setAdapter(adapter_resulst);
    }

}
