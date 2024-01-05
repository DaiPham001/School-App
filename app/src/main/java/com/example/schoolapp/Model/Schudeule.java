package com.example.schoolapp.Model;

import java.io.Serializable;

public class Schudeule extends Class implements Serializable {

    private String tenmon,mamh,tiet,gio,phong,GV;

    public Schudeule(String tenmon,String tenlop,String mamh,String tiet,String gio, String phong,String GV) {
        super(tenlop);
        this.tenmon =tenmon;
        this.mamh = mamh;
        this.tiet = tiet;
        this.gio = gio;
        this.phong = phong;
        this.GV = GV;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public String getTiet() {
        return tiet;
    }

    public void setTiet(String tiet) {
        this.tiet = tiet;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getGV() {
        return GV;
    }

    public void setGV(String GV) {
        this.GV = GV;
    }
}
