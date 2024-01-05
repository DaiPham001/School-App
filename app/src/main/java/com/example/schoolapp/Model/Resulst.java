package com.example.schoolapp.Model;

import java.io.Serializable;

public class Resulst extends Sinhvien implements Serializable {

    private int stt,sotc,img;
    private String mhp,tenmh,diemchu,xeploai;
    private float diemcc,diemhs1,diemhs2,diemhs3,diemck1,diemck2,diemthi,tongdiem,td4;

    public Resulst( int stt, String mhp, String tenmh, int sotc,float diemcc,float diemhs1, float diemhs2,
                   float diemhs3,int img,float diemck1, float diemck2, float diemthi, float tongdiem,  float td4,
                   String diemchu, String xeploai) {
        this.stt = stt;
        this.sotc = sotc;
        this.img = img;
        this.diemchu = diemchu;
        this.xeploai = xeploai;
        this.mhp = mhp;
        this.tenmh = tenmh;
        this.diemcc = diemcc;
        this.diemhs1 = diemhs1;
        this.diemhs2 = diemhs2;
        this.diemhs3 = diemhs3;
        this.diemck1 = diemck1;
        this.diemck2 = diemck2;
        this.diemthi = diemthi;
        this.tongdiem = tongdiem;
        this.td4 = td4;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getSotc() {
        return sotc;
    }

    public void setSotc(int sotc) {
        this.sotc = sotc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getMhp() {
        return mhp;
    }

    public void setMhp(String mhp) {
        this.mhp = mhp;
    }

    public String getTenmh() {
        return tenmh;
    }

    public void setTenmh(String tenmh) {
        this.tenmh = tenmh;
    }

    public String getDiemchu() {
        return diemchu;
    }

    public void setDiemchu(String diemchu) {
        this.diemchu = diemchu;
    }

    public String getXeploai() {
        return xeploai;
    }

    public void setXeploai(String xeploai) {
        this.xeploai = xeploai;
    }

    public float getDiemthi() {
        return diemthi;
    }

    public void setDiemthi(float diemthi) {
        this.diemthi = diemthi;
    }

    public float getTd4() {
        return td4;
    }

    public void setTd4(float td4) {
        this.td4 = td4;
    }

    public float getDiemcc() {
        return diemcc;
    }

    public void setDiemcc(float diemcc) {
        this.diemcc = diemcc;
    }

    public float getDiemhs1() {
        return diemhs1;
    }

    public void setDiemhs1(float diemhs1) {
        this.diemhs1 = diemhs1;
    }

    public float getDiemhs2() {
        return diemhs2;
    }

    public void setDiemhs2(float diemhs2) {
        this.diemhs2 = diemhs2;
    }

    public float getDiemhs3() {
        return diemhs3;
    }

    public void setDiemhs3(float diemhs3) {
        this.diemhs3 = diemhs3;
    }

    public float getDiemck1() {
        return diemck1;
    }

    public void setDiemck1(float diemck1) {
        this.diemck1 = diemck1;
    }

    public float getDiemck2() {
        return diemck2;
    }

    public void setDiemck2(float diemck2) {
        this.diemck2 = diemck2;
    }

    public float getTongdiem() {
        return tongdiem;
    }

    public void setTongdiem(float tongdiem) {
        this.tongdiem = tongdiem;
    }
}
