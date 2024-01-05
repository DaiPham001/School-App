package com.example.schoolapp.DAO;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.schoolapp.Database.DBHelper;
import com.example.schoolapp.Model.Class;
import com.example.schoolapp.Model.Majors;
import com.example.schoolapp.Model.Resulst;
import com.example.schoolapp.Model.Sinhvien;

import java.util.ArrayList;

public class Sinhvien_DAO {
    private DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;
    private SharedPreferences sharedPreferences;

    public Sinhvien_DAO(Context context) {
        dbHelper = new DBHelper(context);
        sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE);
    }

    // check login sinhvien

    public boolean CkeckLoginsv(int msv, String passwrd) {
        sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT s.msv , u.passwrd ,u.role FROM Sinhvien s JOIN User u ON s.id = u.id " +
                        "WHERE s.msv = ? AND u.passwrd = ?",
                new String[]{String.valueOf(msv), passwrd});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("role", cursor.getInt(2));
            editor.putInt("msv", cursor.getInt(0));
            editor.putString("pass",cursor.getString(1));
            editor.apply();
            return true;
        }
//        cursorrole.close();
        cursor.close();
        return false;
    }

    public boolean Person(int msv){
        sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT "  +
                "User.name, " +
                "User.gioitinh, " +
                "Class.tenlop, " +
                "Sinhvien.bacdt, " +
                "Sinhvien.loaihinhdt, " +
                "Majors.tennganh, " +
                "Sinhvien.khoahoc " +
                "FROM Sinhvien " +
                "JOIN User ON Sinhvien.id = User.id " +
                "JOIN Class ON Sinhvien.tenlop = Class.tenlop " +
                "JOIN Majors ON Sinhvien.manganh = Majors.manganh " +
                "WHERE Sinhvien.msv = ?",new String[]{String.valueOf(msv)});
        if (cursor.getCount() >0){
            cursor.moveToFirst();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name",cursor.getString(0));
            editor.putInt("gioitinh",cursor.getInt(1));
            editor.putString("tenlop",cursor.getString(2));
            editor.putString("bacdt",cursor.getString(3));
            editor.putString("loaihinhdt",cursor.getString(4));
            editor.putString("tennganh",cursor.getString(5));
            editor.putString("khoahoc",cursor.getString(6));
            editor.apply();
            return true;
        }
        cursor.close();
        return false;
    }

    public ArrayList<Class> getAllClass(String manganh) {
        ArrayList<Class> list = new ArrayList<>();
        sqLiteDatabase = dbHelper.getReadableDatabase();

        // Truy vấn để lấy các lớp của mã ngành cụ thể
        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT tenlop FROM Class WHERE manganh = ?", new String[]{manganh});
        if (cursor.getCount() >= 0) {
            cursor.moveToFirst();
            do {
                list.add(new Class(cursor.getString(0)));
            } while (cursor.moveToNext());
            cursor.close();
        }

        return list;
    }

    // list user
    public ArrayList<Sinhvien> listsinhvien(String tenlop) {
        ArrayList<Sinhvien> list = new ArrayList<>();
        sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT User.id, Sinhvien.msv, User.name " +
                "FROM User " +
                "INNER JOIN Sinhvien ON User.id = Sinhvien.id " +
                "INNER JOIN Class ON Sinhvien.tenlop = Class.tenlop " +
                "WHERE Class.tenlop = ?", new String[]{tenlop});
        if (cursor.getCount() >= 0) {
            cursor.moveToFirst();
            do {
                list.add(new Sinhvien(cursor.getInt(0), cursor.getString(2), cursor.getInt(1)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    // list Majors
    public ArrayList<Majors> ListMajors() {
        ArrayList<Majors> list = new ArrayList<>();
        sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Majors", null);
        if (cursor.getCount() >= 0) {
            cursor.moveToFirst();
            do {
                list.add(new Majors(cursor.getString(0), cursor.getString(1)));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public ArrayList<Resulst> getResults(int msv) {
        ArrayList<Resulst> list = new ArrayList<>();
        sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT Results.*, Subject.mamh AS subject_mamh, Subject.tenmh " +
                "FROM Results " +
                "JOIN Subject ON Results.mamh = Subject.mamh " +
                "WHERE Results.msv = ?", new String[]{String.valueOf(msv)});

        int columnIndexSubjectMamh = cursor.getColumnIndex("subject_mamh");
        int columnIndexTenMH = cursor.getColumnIndex("tenmh");

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                list.add(new Resulst(cursor.getInt(0), cursor.getString(columnIndexSubjectMamh),
                        cursor.getString(columnIndexTenMH), cursor.getInt(3), cursor.getFloat(4),
                        cursor.getFloat(5), cursor.getFloat(6), cursor.getFloat(7),
                        cursor.getInt(8), cursor.getFloat(9), cursor.getFloat(10),
                        cursor.getFloat(11), cursor.getFloat(12), cursor.getFloat(13),
                        cursor.getString(14), cursor.getString(15)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }




}
