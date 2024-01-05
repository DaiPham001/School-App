package com.example.schoolapp.Model;

import java.io.Serializable;

public class Majors implements Serializable {
    private String manganh,nganh;

    public Majors(String manganh, String nganh) {
        this.manganh = manganh;
        this.nganh = nganh;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getManganh() {
        return manganh;
    }

    public void setManganh(String manganh) {
        this.manganh = manganh;
    }
}
