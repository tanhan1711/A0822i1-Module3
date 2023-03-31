package com.example.demo1.model;

import java.util.Date;

public class Nhanvien {
    private int manv ;
    private String tennv ;
    private Date ngaysinh ;
    private String diachi ;
    private Date ngaybatdau ;
    private Date ngayketthuc ;
    private double luong ;
    private Congviec congviec;

    public Nhanvien(int manv, String tennv, Date ngaysinh, String diachi, Date ngaybatdau, Date ngayketthuc, double luong) {
        this.manv = manv;
        this.tennv = tennv;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.luong = luong;
    }

    public Nhanvien() {
    }

    public Nhanvien(int manv, String tennv, Date ngaysinh, String diachi, Date ngaybatdau, Date ngayketthuc, double luong, Congviec congviec) {
        this.manv = manv;
        this.tennv = tennv;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.luong = luong;
        this.congviec = congviec;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Date getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public Congviec getCongviec() {
        return congviec;
    }

    public void setCongviec(Congviec congviec) {
        this.congviec = congviec;
    }
}
