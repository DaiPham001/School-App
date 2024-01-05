package com.example.schoolapp.Model;

import android.util.Log;

import java.io.Serializable;
import java.util.Date;

public class Sinhvien extends User implements Serializable {

    private int msv;
    private String clas,khoahoc,bacdt,loaihnhdt,nganh;

    public Sinhvien(int id, String name,int msv) {
        super(id,name);
        this.msv = msv;
    }

    public Sinhvien() {
    }

    public Sinhvien(String clas) {
        this.clas = clas;
    }

    public String getKhoahoc() {
        return khoahoc;
    }

    public void setKhoahoc(String khoahoc) {
        this.khoahoc = khoahoc;
    }

    public int getMsv() {
        return msv;
    }

    public void setMsv(int msv) {
        this.msv = msv;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getBacdt() {
        return bacdt;
    }

    public void setBacdt(String bacdt) {
        this.bacdt = bacdt;
    }

    public String getLoaihnhdt() {
        return loaihnhdt;
    }

    public void setLoaihnhdt(String loaihnhdt) {
        this.loaihnhdt = loaihnhdt;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }


    @Override
    public String toString() {
        return "Sinhvien{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", msv=" + msv +
                // Thêm các thuộc tính khác nếu cần
                '}';
    }
}
