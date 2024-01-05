package com.example.schoolapp.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import com.example.schoolapp.DAO.Sinhvien_DAO;

public class Sinhvien_Service extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // nhận dữ liệu từ LoginActivity
        Bundle bundle = intent.getExtras();
        String msv = bundle.getString("msv");
        String password = bundle.getString("password");

        SharedPreferences sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
        String passwrd =sharedPreferences.getString("pass","");

        Sinhvien_DAO sinhvien_dao = new Sinhvien_DAO(this);
        boolean check = sinhvien_dao.CkeckLoginsv(Integer.parseInt(msv),password);
                // truyền dữ liệu lại cho loginActivity
                Intent intentbr = new Intent();
                Bundle bundlebr = new Bundle();
                bundlebr.putBoolean("check",check);

                intentbr.setAction("checklogin");
                intentbr.putExtras(bundlebr);
                sendBroadcast(intentbr);


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}