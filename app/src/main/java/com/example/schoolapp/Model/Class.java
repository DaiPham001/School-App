package com.example.schoolapp.Model;

import java.io.Serializable;

public class Class implements Serializable {

    private String tenlop,manganh;

    public Class(String tenlop, String manganh) {
        this.tenlop = tenlop;
        this.manganh = manganh;
    }

    public Class(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getManganh() {
        return manganh;
    }

    public void setManganh(String manganh) {
        this.manganh = manganh;
    }
}
