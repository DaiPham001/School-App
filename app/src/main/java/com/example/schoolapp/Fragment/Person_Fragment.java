package com.example.schoolapp.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.schoolapp.DAO.Sinhvien_DAO;
import com.example.schoolapp.Model.Sinhvien;
import com.example.schoolapp.R;

import java.util.ArrayList;

public class Person_Fragment extends Fragment {
    int posion;
    private TextView tv_mssv, tv_ten, tv_sex, tv_tt, tv_lop, tv_bacdt, tv_khoa, tv_cn, tv_nvt, tv_cs, tv_loaihdt, tv_nganh, tv_khoahoc;
    private SpannableString spannableString;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_person_, container, false);
        addcontroll(view);
        addevenst();
        return view;
    }


    // ánh xạ view
    private void addcontroll(View view) {
        tv_mssv = view.findViewById(R.id.tv_mssv);
        tv_ten = view.findViewById(R.id.tv_ten);
        tv_sex = view.findViewById(R.id.tv_sex);
        tv_tt = view.findViewById(R.id.tv_tt);
        tv_lop = view.findViewById(R.id.tv_lop);
        tv_bacdt = view.findViewById(R.id.tv_bacdt);
        tv_khoa = view.findViewById(R.id.tv_khoa);
        tv_cn = view.findViewById(R.id.tv_cn);
        tv_nvt = view.findViewById(R.id.tv_nvt);
        tv_cs = view.findViewById(R.id.tv_cs);
        tv_loaihdt = view.findViewById(R.id.tv_loaihdt);
        tv_nganh = view.findViewById(R.id.tv_nganh);
        tv_khoahoc = view.findViewById(R.id.tv_khoahoc);
    }

    private void addevenst() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        int msv = sharedPreferences.getInt("msv", -1);
        String name = sharedPreferences.getString("name", "");
        String tenlop = sharedPreferences.getString("tenlop", "");
        int gioitinh = sharedPreferences.getInt("gioitinh", -1);
        String bacdt = sharedPreferences.getString("bacdt", "");
        String loaihinhdt = sharedPreferences.getString("loaihinhdt", "");
        String tennganh = sharedPreferences.getString("tennganh", "");
        String khoahoc = sharedPreferences.getString("khoahoc", "");

//        Log.e("name", name);
//        Log.e("tenlop", tenlop);
//        Log.e("gioitinh", String.valueOf(gioitinh));
//        Sinhvien sinhvien = new Sinhvien()

        // Chuỗi đầy đủ
        String msvfull = String.valueOf(msv);
        String fullString = "MSSV: " + msvfull;

        // Tìm vị trí của "MSSV" trong chuỗi đầy đủ
        int startIndexmsv = fullString.indexOf(msvfull);
        if (startIndexmsv != -1) {
            spannableString = new SpannableString(fullString);
            int endIndex = startIndexmsv + msvfull.length();
            spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), startIndexmsv, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv_mssv.setText(spannableString);
        }

        String fullname = "Họ tên: " + name;
        // Tìm vị trí trong chuỗi đầy đủ
        int startIndexname = fullname.indexOf(name);
        if (startIndexname != -1) {
            spannableString = new SpannableString(fullname);
            int endIndex = startIndexname + name.length();
            spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), startIndexname, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv_ten.setText(spannableString);
        }

        String nam = "Nam";
        String nu = "Nữ";
        String fullsex = "Giới tính: ";

        if (gioitinh == 1) {
            fullsex += nam;
        } else {
            fullsex += nu;
        }
        int startIndexsex = fullsex.indexOf(nam);
        if (startIndexsex == -1) {
            startIndexsex = fullsex.indexOf(nu);
        }
        if (startIndexsex != -1) {
             spannableString = new SpannableString(fullsex);
            int endIndex = startIndexsex + (gioitinh == 1 ? nam.length() : nu.length());
            spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), startIndexsex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv_sex.setText(spannableString);
        } else {
            tv_sex.setText(fullsex);
        }


        String fulllop = "Lớp: " + tenlop;
        // Tìm vị trí  trong chuỗi đầy đủ
        int startIndexlop = fulllop.indexOf(tenlop);
        if (startIndexlop != -1) {
            spannableString = new SpannableString(fulllop);
            int endIndex = startIndexlop + tenlop.length();
            spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), startIndexlop, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv_lop.setText(spannableString);
        }

        String fullbacdt = "Bậc đào tạo: " + bacdt;
        // Tìm vị trí   trong chuỗi đầy đủ
        int startIndexbacdt = fullbacdt.indexOf(bacdt);
        if (startIndexbacdt != -1) {
            spannableString = new SpannableString(fullbacdt);
            int endIndex = startIndexbacdt + bacdt.length();
            spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), startIndexbacdt, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv_bacdt.setText(spannableString);
        }

        String fullloaihdt = "Loại hình đào tạo: " + loaihinhdt;
        // Tìm vị trí   trong chuỗi đầy đủ
        int startIndexloaihdt = fullloaihdt.indexOf(loaihinhdt);
        if (startIndexloaihdt != -1) {
            spannableString = new SpannableString(fullloaihdt);
            int endIndex = startIndexloaihdt + loaihinhdt.length();
            spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), startIndexloaihdt, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv_loaihdt.setText(spannableString);
        }

        String fullnganh = "Ngành: " + tennganh;
        // Tìm vị trí   trong chuỗi đầy đủ
        int startIndexnganh = fullnganh.indexOf(tennganh);
        if (startIndexnganh != -1) {
            spannableString = new SpannableString(fullnganh);
            int endIndex = startIndexnganh + tennganh.length();
            spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), startIndexnganh, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv_nganh.setText(spannableString);
        }

        String full_khoahoc = "Khóa học: " + khoahoc;
        // Tìm vị trí   trong chuỗi đầy đủ
        int startIndexkhoa = full_khoahoc.indexOf(khoahoc);
        if (startIndexkhoa != -1) {
            spannableString = new SpannableString(full_khoahoc);
            int endIndex = startIndexkhoa + khoahoc.length();
            spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), startIndexkhoa, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv_khoahoc.setText(spannableString);
        }

        //Log.e("mssv",tv_mssv.getText().toString());


    }
}