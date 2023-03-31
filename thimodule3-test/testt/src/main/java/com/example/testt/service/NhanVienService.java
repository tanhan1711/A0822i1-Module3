package com.example.testt.service;

import com.example.testt.bean.NhanVien;

import java.sql.SQLException;
import java.util.List;

public interface NhanVienService {
    void add(NhanVien nhanVien);
    void update(NhanVien nhanVien);
    List<NhanVien> findAll();
    List<NhanVien> findByTenCongViec(String tenCongViec);
    List<NhanVien> findByNgayLamVaNgayKetThuc(String ngayBatDauLam, String ngayKetThucLam);

    public NhanVien selectNhanVien(int manv);
    public boolean deleteUser(int id) throws SQLException;

}

