package com.example.demo1.repository;

import com.example.demo1.model.Congviec;
import com.example.demo1.model.Nhanvien;

import java.sql.SQLException;
import java.util.List;

public interface ICongviecRepo {
    public void insertUser(Congviec congviec) throws SQLException;

    public Congviec selectUser(int macv);

    public List<Congviec> selectAllUsers();

    public boolean deleteUser(int macv) throws SQLException;

    public boolean updateUser(Congviec congviec) throws SQLException;
    public List<Congviec> findBytencv(String tencv) throws SQLException;

    Congviec findById(String maCongViec);
}
