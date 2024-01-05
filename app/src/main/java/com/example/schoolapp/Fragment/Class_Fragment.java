package com.example.schoolapp.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolapp.Adapter.Adapter_Class;
import com.example.schoolapp.DAO.Sinhvien_DAO;
import com.example.schoolapp.Listenner.Lintenner_class;
import com.example.schoolapp.Model.Class;
import com.example.schoolapp.Model.Sinhvien;
import com.example.schoolapp.R;

import java.util.ArrayList;

public class Class_Fragment extends Fragment implements Lintenner_class {
    private RecyclerView rcv_class;
    private ArrayList<Class> list;
    private Sinhvien_DAO sinhvien_dao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_class,container,false);
        addcontroll(view);
        Loadlist();
        return view;
    }

    private void Loadlist() {

        // nhận dư liệu từ fragment_Majors
        String manganh = getArguments().getString("manganh");
        //Log.e("manganh",manganh);
        // khởi tạo
        sinhvien_dao = new Sinhvien_DAO(getContext());
        list = sinhvien_dao.getAllClass(manganh);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcv_class.setLayoutManager(linearLayoutManager);
        Adapter_Class  adapter_class = new Adapter_Class(list,getContext(),this);
        rcv_class.setAdapter(adapter_class);
        // dòng kẻ của rcv
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rcv_class.addItemDecoration(itemDecoration);

    }

    // ánh xạ view
    private void addcontroll(View view) {
        rcv_class = view.findViewById(R.id.rcv_class);
    }

    // sự kiện rcv_class
    @Override
    public void Click_Class(Class aClass) {
        Bundle bundle = new Bundle();
        String tenlop = aClass.getTenlop();
        bundle.putString("tenlop",tenlop);
        User_Fragment fragment = new User_Fragment();
        fragment.setArguments(bundle);

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flcontent, fragment)
                .commit();

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Danh sách sinh viên: "+aClass.getTenlop());
    }
}