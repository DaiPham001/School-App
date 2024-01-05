package com.example.schoolapp.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.example.schoolapp.DAO.Changer_DAo;
import com.example.schoolapp.Model.User;

public class ChangeService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SharedPreferences sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
        String password =sharedPreferences.getString("pass","");
        int msv = sharedPreferences.getInt("msv",-1);
        Log.e("pass",password);
        Log.e("msv",String.valueOf(msv));

        Bundle bundle = intent.getExtras();
        String passold = bundle.getString("passold");
        String passnew = bundle.getString("passnew");
        String passchange = bundle.getString("passchange");

        User user = new User(passold);

        Changer_DAo changer_dAo = new Changer_DAo(this);
        boolean check = changer_dAo.UpdateChange(msv,passnew);


        if (passold.equals("") || passchange.equals("") || passnew.equals("")) {
                    Toast.makeText(this, "Yêu cầu nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                } else if (!passold.equals(password)) {
                    Toast.makeText(this, "Mật khẩu cũ không đúng", Toast.LENGTH_SHORT).show();
                } else if (!passnew.equals(passchange)){
                    Toast.makeText(this, "Mật khẩu không giống nhau !", Toast.LENGTH_SHORT).show();
                }else if (passold.equals(password)) {
                    if (check == true){
                        Intent intentbr = new Intent();
                        Bundle bundlebr = new Bundle();
                        bundlebr.putBoolean("check",check);
                        intentbr.putExtras(bundlebr);
                        intentbr.setAction("checkpass");
                        sendBroadcast(intentbr);
                    }
                }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}