package com.example.schoolapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.schoolapp.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ScreenActivity extends AppCompatActivity {

    private CircleImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        addcontroll();
        Glide.with(this).load(R.drawable.fbu).into(i);
        // tự động chuyển màn hình
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ScreenActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();// đóng activity
            }
        },1000); // thời gian chay
    }

    private void addcontroll() {
        i = findViewById(R.id.i);
    }
}