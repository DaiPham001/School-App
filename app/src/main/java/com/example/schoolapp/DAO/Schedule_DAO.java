package com.example.schoolapp.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.schoolapp.Database.DBHelper;
import com.example.schoolapp.Model.Schudeule;

import java.util.ArrayList;

public class Schedule_DAO {
    private DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;
    public Schedule_DAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public ArrayList<Schudeule> getSchedule(int msv){
        ArrayList<Schudeule> list = new ArrayList<>();
        sqLiteDatabase = dbHelper.getReadableDatabase();

        // Truy vấn để lấy các lớp của mã ngành cụ thể
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT Subject.tenmh, Class.tenlop, Schedule.mamh, Schedule.tiet, Schedule.gio, Schedule.room, User.name " +
                "FROM Schedule " +
                "JOIN Sinhvien ON Schedule.msv = Sinhvien.msv " +
                "JOIN Subject ON Schedule.mamh = Subject.mamh " +
                "JOIN Class ON Schedule.tenlop = Class.tenlop " +
                "LEFT JOIN Teacher ON Schedule.mgv = Teacher.mgv " +
                "LEFT JOIN User ON Teacher.id = User.id " +
                "WHERE Sinhvien.msv = ? AND (User.role IS NULL OR User.role = 2)",new String[]{String.valueOf(msv)});
        if (cursor.getCount() >=0 ){
            cursor.moveToFirst();
            do {
                list.add(new Schudeule(cursor.getString(0),cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),cursor.getString(4),
                        cursor.getString(5),cursor.getString(6)));
            }while (cursor.moveToNext());
        }
        return list;
    }
}
