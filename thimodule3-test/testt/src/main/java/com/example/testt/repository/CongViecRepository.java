package com.example.testt.repository;

import com.example.testt.bean.CongViec;

import java.util.List;

public interface CongViecRepository {
    CongViec findById(String maCongViec);
    List<CongViec> findAll();

}

