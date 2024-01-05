package com.example.schoolapp.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolapp.Adapter.Adapter_Majors;
import com.example.schoolapp.DAO.Sinhvien_DAO;
import com.example.schoolapp.Listenner.Listenner_mj;
import com.example.schoolapp.Model.Majors;
import com.example.schoolapp.R;

import java.util.ArrayList;


public class Majors_Fragment extends Fragment implements Listenner_mj {

    private RecyclerView rcv_majors;
    private ArrayList<Majors> list;
    private Sinhvien_DAO sinhvien_dao;
    private Adapter_Majors adapter_majors;
    private Fragment fragment = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_majors, container, false);
        addcontroll(view);
        adddatasv();
        return view;
    }

    // ánh xạ view
    private void addcontroll(View view) {
        rcv_majors = view.findViewById(R.id.rcv_mj);
        sinhvien_dao = new Sinhvien_DAO(getContext());
        Loadlist();
    }

    //load data sv
    private void adddatasv() {

    }

    // load len rcv
    public void Loadlist() {
        list = sinhvien_dao.ListMajors();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcv_majors.setLayoutManager(linearLayoutManager);
        adapter_majors = new Adapter_Majors(list, getContext(), this);
        rcv_majors.setAdapter(adapter_majors);

        // dòng kẻ của rcv
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rcv_majors.addItemDecoration(itemDecoration);
    }


    // add sự kiện cho rcv
    @Override
    public void Click_Majors(Majors majors) {
        Bundle bundle = new Bundle();
        String manganh = majors.getManganh();
        bundle.putString("manganh",manganh);
        fragment = new Class_Fragment();
        fragment.setArguments(bundle);

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flcontent, fragment)
                .commit();

            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Danh sách lớp: "+majors.getNganh());
    }

}