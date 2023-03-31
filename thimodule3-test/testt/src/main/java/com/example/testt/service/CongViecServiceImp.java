package com.example.testt.service;

import com.example.testt.bean.CongViec;
import com.example.testt.repository.CongViecRepository;
import com.example.testt.repository.CongViecRepositoryImp;

import java.util.List;

public class CongViecServiceImp implements CongViecService {
    private CongViecRepository repository = new CongViecRepositoryImp();
    @Override
    public CongViec findById(String maCongViec) {
        return repository.findById(maCongViec);
    }

    @Override
    public List<CongViec> findAll() {
        return repository.findAll();
    }


}
