package com.example.demo1.model;

public class Congviec {
    private String macv;
    private String tencv;
    private double luongthap;
    private double luongcao;

    public Congviec(String macv, String tencv, double luongthap, double luongcao) {
        this.macv = macv;
        this.tencv = tencv;
        this.luongthap = luongthap;
        this.luongcao = luongcao;
    }

    public Congviec() {
    }

    public String getMacv() {
        return macv;
    }

    public void setMacv(String macv) {
        this.macv = macv;
    }

    public String getTencv() {
        return tencv;
    }

    public void setTencv(String tencv) {
        this.tencv = tencv;
    }

    public double getLuongthap() {
        return luongthap;
    }

    public void setLuongthap(double luongthap) {
        this.luongthap = luongthap;
    }

    public double getLuongcao() {
        return luongcao;
    }

    public void setLuongcao(double luongcao) {
        this.luongcao = luongcao;
    }
}
