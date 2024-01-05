package com.example.schoolapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.schoolapp.Model.Sinhvien;
import com.example.schoolapp.R;
import com.example.schoolapp.Service.Sinhvien_Service;


public class LoginActivity extends AppCompatActivity {
    private EditText ed_msv, ed_pass;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addontroll();
        addevenst();

    }


    // method ánh xạ view
    private void addontroll() {
        ed_pass = findViewById(R.id.ed_pass);
        ed_msv = findViewById(R.id.ed_msv);
        btn_login = findViewById(R.id.btn_login);

    }

    // medthod xử lý sự kiện
    private void addevenst() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed_msv.getText().toString().equals("") || ed_pass.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Nhập tài khoản và Mật khẩu !", Toast.LENGTH_SHORT).show();
                }

                String msv = ed_msv.getText().toString().trim();
                String password = ed_pass.getText().toString().trim();
                // đóng gói và truyền dữ liệu xuống sinhviens_service
                Intent intent = new Intent(LoginActivity.this, Sinhvien_Service.class);
                Bundle bundle = new Bundle();
                bundle.putString("msv",msv);
                bundle.putString("password",password);
                intent.putExtras(bundle);
                startService(intent);
            }
        });
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "checklogin":
                    Bundle bundle = intent.getExtras();
                    boolean check = bundle.getBoolean("check");
                    if (check == true){
                        Toast.makeText(context, "thành công", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent1);
                        finish();
                    }else {
                        Toast.makeText(context, "Tài khoản hoặc mật khẩu sai !", Toast.LENGTH_SHORT).show();
                    }
            }
        }
    };

    @Override
    protected void onResume() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("checklogin");
        super.onResume();
        registerReceiver(broadcastReceiver,intentFilter);
    }
}