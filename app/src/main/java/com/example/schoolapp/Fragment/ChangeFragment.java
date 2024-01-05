package com.example.schoolapp.Fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.schoolapp.R;
import com.example.schoolapp.Service.ChangeService;
import com.google.android.material.textfield.TextInputEditText;

public class ChangeFragment extends Fragment {
    private TextInputEditText ed_pass_old, ed_passnew, ed_pass_change;
    private Button btn_save, btn_huy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_change, container, false);
        addontroll(view);
        addevenst();
        return view;
    }

    // ánh xạ view
    private void addontroll(View view) {
        btn_huy = view.findViewById(R.id.btn_huy);
        btn_save = view.findViewById(R.id.btn_save);
        ed_pass_old = view.findViewById(R.id.ed_pass_old);
        ed_passnew = view.findViewById(R.id.ed_pass_new);
        ed_pass_change = view.findViewById(R.id.ed_pass_change);
    }


    // xử lý sự kiện
    private void addevenst() {
        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_passnew.setText("");
                ed_pass_change.setText("");
                ed_pass_old.setText("");
            }
        });

        //


        SharedPreferences sharedPreferences = getContext().getSharedPreferences("User", Context.MODE_PRIVATE);
        String password = sharedPreferences.getString("pass", "");
        Log.e("pass", password);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passold = ed_pass_old.getText().toString().trim();
                String passnew = ed_passnew.getText().toString().trim();
                String passchange = ed_pass_change.getText().toString().trim();
                Intent intent = new Intent(getActivity(), ChangeService.class);
                Bundle bundle = new Bundle();
                bundle.putString("passold", passold);
                bundle.putString("passnew", passnew);
                bundle.putString("passchange", passchange);
                intent.putExtras(bundle);
                getActivity().startService(intent);
            }
        });
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "checkpass":
                    Bundle bundle = intent.getExtras();
                    boolean check = bundle.getBoolean("check");
                    if (check == true){
                        Toast.makeText(context, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(context, "Đổi mật khẩu thất bại", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("checkpass");
        getActivity().registerReceiver(broadcastReceiver,intentFilter);
    }
}