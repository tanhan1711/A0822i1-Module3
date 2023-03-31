package com.example.demo1.repository;

import com.example.demo1.model.Nhanvien;

import java.sql.SQLException;
import java.util.List;

public interface INhanvienRepo {
    public void insertUser(Nhanvien nhanvien) throws SQLException;

    public Nhanvien selectUser(int manv);

    public List<Nhanvien> selectAllUsers();

    public boolean deleteUser(int manv) throws SQLException;

    public boolean updateUser(Nhanvien nhanvien) throws SQLException;
    public List<Nhanvien> findBytencv(String tencv) throws SQLException;

}
