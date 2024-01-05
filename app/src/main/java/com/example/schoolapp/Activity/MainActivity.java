package com.example.schoolapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.schoolapp.Fragment.ChangeFragment;
import com.example.schoolapp.Fragment.Course_Fragment;
import com.example.schoolapp.Fragment.HomePage_Fragment;
import com.example.schoolapp.Fragment.Majors_Fragment;
import com.example.schoolapp.Fragment.Person_Fragment;
import com.example.schoolapp.Fragment.Results_Fragment;
import com.example.schoolapp.Fragment.Schedule_Fragment;
import com.example.schoolapp.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private View headerView;
    private long backPressedTime;
    private Toast mToast;
    private NavigationView naview;
    private Fragment fragment = null;
    //String titletoolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontroll();
        addevenst();
        Hierarchy();// phân cấp
    }

    // ánh xạ view
    private void addcontroll() {
        drawerLayout = findViewById(R.id.drawerlayout);
        toolbar = findViewById(R.id.toolbar);
        naview = findViewById(R.id.naview);

        // hiển thị navigation
        headerView = naview.getHeaderView(0);


        //hiển thị toobar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menutobar);
    }

    // sử lý hoạt động
    private void addevenst() {
        // set fragment mặc định
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flcontent, new HomePage_Fragment())
                .commit();
        naview.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.user:
                    fragment = new Majors_Fragment();
                    getFragment();
                    break;
                case R.id.logout:
                    logout();
                    break;
                case R.id.ttsv:
                    fragment = new Person_Fragment();
                    getFragment();
                    break;
                case R.id.kq:
                    fragment = new Results_Fragment();
                    getFragment();
                    break;
                case R.id.lh:
                    fragment = new Schedule_Fragment();
                    getFragment();
                    break;
                case R.id.sub_pass:
                    fragment = new ChangeFragment();
                    getFragment();
                    break;
                case R.id.dkthi:
                    fragment =new Course_Fragment() ;
                    getFragment();
                    break;
                default:

                    break;
            }

            // đổi title fragment
            getSupportActionBar().setTitle(item.getTitle());

            drawerLayout.closeDrawers();
            return false;
        });

        /// add hoạt động cho img về trang chủ
        View view = naview.getHeaderView(0);
        ImageView img_user = view.findViewById(R.id.img_user);
        img_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new HomePage_Fragment();
                getFragment();

                // trọn item navigation xong ẩn navigation
                drawerLayout.closeDrawer(GravityCompat.START);// thì đóng
            }
        });
    }

    // hàm sử lý hoạt động toolbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);// mở navigation bên trái
        }
        return super.onOptionsItemSelected(item);
    }

    // method khởi tạo fragment
    public void getFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flcontent, fragment)
                .addToBackStack(null)
                .commit();
    }

    //
    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int fragmentCount = fragmentManager.getBackStackEntryCount();

        if (fragmentCount > 0) {
            fragmentManager.popBackStack();
        } else {
            if (backPressedTime + 2000 > System.currentTimeMillis()) {
                mToast.cancel();
                super.onBackPressed();
                return;
            } else {
                mToast = Toast.makeText(this, "Press back again to exit!", Toast.LENGTH_SHORT);
                mToast.show();
            }
            backPressedTime = System.currentTimeMillis();
        }
    }

    // phân cấp người dùng
    private void Hierarchy() {
        // lấy role
        SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
        int role = sharedPreferences.getInt("role", -1);// -1 là giá trị nếu nó không tìm thấy
        Log.e("role", String.valueOf(role));
        Menu menu = naview.getMenu();
        switch (role) {
            case 1:
                menu.findItem(R.id.user).setVisible(false);
                menu.findItem(R.id.ttsv).setVisible(true);
                break;
            case 2:
                menu.findItem(R.id.user).setVisible(true);
                menu.findItem(R.id.ttsv).setVisible(false);
                break;
        }
    }

    // đăng xuất
    private void logout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Đăng xuất khỏi tài khoản của ban ?");
        builder.setPositiveButton("Đăng xuất", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        builder.setNegativeButton("Hủy", null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
