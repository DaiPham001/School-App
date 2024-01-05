package com.example.schoolapp.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.schoolapp.R;


public class HomePage_Fragment extends Fragment {

    private ImageView img_tt, img_chart, img_calendar, img_course;
    private Fragment fragment = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home_page_, container, false);
        addcontroll(view);
        addevenst();
        return view;
    }

    // ánh xạ view
    private void addcontroll(View view) {
        img_tt = view.findViewById(R.id.img_tt);
        img_chart = view.findViewById(R.id.img_chart);
        img_calendar = view.findViewById(R.id.img_calendar);
        img_course = view.findViewById(R.id.img_course);
    }

    // xử lý hoạt động
    private void addevenst() {

        img_tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new Person_Fragment();
                getFragment("Thông in sinh viên");
            }
        });

        //
        img_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new Results_Fragment();
                getFragment("Kết quả học tập");
            }
        });
        //
        img_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new Schedule_Fragment();
                getFragment("Lịch học");
            }
        });

        //
        img_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    // method khởi tạo fragment
    public void getFragment(String title) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flcontent, fragment)
                .addToBackStack(null)
                .commit();

        // Update the toolbar title
        updateToolbarTitle(title);
    }

    private void updateToolbarTitle(String title) {
        // Assuming you have a Toolbar in your activity
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        Toolbar toolbar = activity.findViewById(R.id.toolbar); // Replace 'R.id.toolbar' with the actual ID of your toolbar
        if (toolbar != null) {
            toolbar.setTitle(title);
        }
    }
}