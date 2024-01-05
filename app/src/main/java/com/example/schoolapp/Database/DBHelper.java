package com.example.schoolapp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String NAME= "schoolapp";
    private static final int VERSION =1;
    public DBHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // tạo bảng nganh
        String db_Majors = "CREATE TABLE Majors(manganh TEXT PRIMARY KEY , tennganh TEXT)";
        db.execSQL(db_Majors);

        // thêm dữ liệu vào bảng ngành
        String d_Majors = "INSERT INTO Majors VALUES('CNTT','công nghệ thông tin'),('KT','Kế toán')";
        db.execSQL(d_Majors);

        // thêm bảng class
        String db_class= "CREATE TABLE Class(tenlop PRIMARY KEY, manganh TEXT REFERENCES Majors(manganh))";
        db.execSQL(db_class);

        // thêm dữ liệu vào bảng class
        String d_class = "INSERT INTO Class VALUES('D094801','CNTT'),('D094802','KT')";
        db.execSQL(d_class);

        // tạo bảng user
        String db_user = "CREATE TABLE User (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, passwrd TEXT, gioitinh INTEGER, ngaysinh DATE, address TEXT, role INTEGER)";
        db.execSQL(db_user);

        // thêm dữ liệu vào bảng user
        String d_user = "INSERT INTO User VALUES (1,'Phạm Văn Đại', '123456', 1, '2002-07-06', 'Hà nội', 1),(2,'Phạm Văn dương', '123456', 0, '2004-07-06', 'Hà nội', 1)," +
                "(3,'Phạm Văn d', '123456', 0, '2004-07-06', 'Hà nội', 2)";
        db.execSQL(d_user);

        // tạo bảng sinhvien
        String db_sinhvien = "CREATE TABLE Sinhvien(msv INTEGER PRIMARY KEY , id INTEGER REFERENCES User(id)," +
                "tenlop TEXT REFERENCES Class(tenlop)" +
                " ,khoahoc TEXT , bacdt TEXT ,loaihinhdt TEXT " +
                ", manganh TEXT REFERENCES Majors(manganh))";
        db.execSQL(db_sinhvien);

        // thêm dữ liệu vào bảng sinhvien
        String d_sinhvien = "INSERT INTO Sinhvien VALUES(01, 1,'D094801' , '2020 - 2024', 'đại học' , 'chinh quy', 'CNTT'),(02, 2,'D094802' , '2020 - 2024', 'đại học' , 'chinh quy', 'KT')";
        db.execSQL(d_sinhvien);

        // Tạo bảng môn học
        String db_subject = "CREATE TABLE Subject(mamh TEXT PRIMARY KEY, tenmh TEXT)";
        db.execSQL(db_subject);
        // Thêm dữ liệu vào bảng subject
        String d_subject = "INSERT INTO Subject VALUES('LTJAVA1','Lập trình JAVA 1'),('LTAndroid','Lập trình Android')";
        db.execSQL(d_subject);

        // Tạo bảng teacher
        String db_teacher = "CREATE TABLE Teacher (mgv  TEXT  PRIMARY KEY, id INTEGER REFERENCES User (id),mamh TEXT REFERENCES Subject (mamh))";
        db.execSQL(db_teacher);
        // Thêm dữ liệu vào bảng teacher
        String d_teacher = "INSERT INTO Teacher VALUES('GV01', 3, 'LTJAVA1'),('GV02', 3, 'LTAndroid')";
        db.execSQL(d_teacher);

        // Tạo bảng schedule
        String db_schedule = "CREATE TABLE Schedule(msv INTEGER REFERENCES Sinhvien(msv), mamh TEXT REFERENCES Subject(mamh), " +
                "tenlop TEXT REFERENCES Class(tenlop), tiet TEXT, gio TEXT, room TEXT, mgv TEXT REFERENCES Teacher(mgv))";
        db.execSQL(db_schedule);

        // Thêm dữ liệu vào bảng schedule
        String d_schedule = "INSERT INTO Schedule(msv, mamh, tenlop, tiet, gio, room, mgv) VALUES " +
                "(01, 'LTJAVA1', 'D094801', '4 - 6', '9:30 - 12:30', 'P.502', 'GV01'), " +
                "(01, 'LTAndroid', 'D094801', '1 - 3', '7:30 - 9:30', 'P.202', 'GV01')";
        db.execSQL(d_schedule);


        // tạo bảng kết quả học tập
        String db_Results= "CREATE TABLE Results(msv INTEGER REFERENCES Sinhvien(msv),stt INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",mamh TEXT REFERENCES Subject(mamh),sotc INTEGER,diemcc FLOAT, diemhs1 FLOAT,diemhs2 FLOAT" +
                ", diemhs3 FLOAT,img INTEGER, diemck1 FLOAT, diemck2 FLOAT,diemthi FLOAT,tongdiem FLOAT,td4 FLOAT,diemchu TEXT,xeploai TEXT)";
        db.execSQL(db_Results);
        // thêm dữ liệu vào bảng
        String d_results = "INSERT INTO Results VALUES(01,1,'LTJAVA1',3,9,6,7,8,1,8,9,9,6,3.5,'A','Giỏi'),(02,2,'LTAndroid',4,9,6,7,8,0,8,2,1,6,3.5,'D','Yếu')";
        db.execSQL(d_results);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS User");
        db.execSQL("DROP TABLE IF EXISTS Sinhvien");
        db.execSQL("DROP TABLE IF EXISTS Majors");
        db.execSQL("DROP TABLE IF EXISTS Class");
        db.execSQL("DROP TABLE IF EXISTS Results");
        db.execSQL("DROP TABLE IF EXISTS Subject");
        db.execSQL("DROP TABLE IF EXISTS Schedule");
        db.execSQL("DROP TABLE IF EXISTS Teacher");
        onCreate(db);
    }
}
