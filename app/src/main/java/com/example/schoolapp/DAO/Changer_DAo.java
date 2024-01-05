package com.example.schoolapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.schoolapp.Database.DBHelper;
import com.example.schoolapp.Model.User;

public class Changer_DAo {

    private DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public Changer_DAo(Context context) {
        this.dbHelper = dbHelper = new DBHelper(context);
    }

    public boolean UpdateChange(int msv, String password) {
        sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("passwrd", password);

        // Update the User table where the id matches the id from the Sinhvien table based on msv
        int check = sqLiteDatabase.update(
                "User",
                values,
                "id = (SELECT id FROM Sinhvien WHERE msv = ?)",
                new String[]{String.valueOf(msv)}
        );

        if (check >= 0) {
            return true;  // Update successful
        }
        return false;  // Update failed
    }

}
