package com.example.testt.service;

import com.example.testt.bean.NhanVien;
import com.example.testt.repository.NhanVienRepository;
import com.example.testt.repository.NhanVienRepositoryImp;

import java.sql.SQLException;
import java.util.List;

public class NhanVienServiceImp implements NhanVienService{
    private NhanVienRepository repository = new NhanVienRepositoryImp();
    @Override
    public void add(NhanVien nhanVien) {
        repository.add(nhanVien);
    }

    @Override
    public void update(NhanVien nhanVien) {
        repository.update(nhanVien);
    }

    @Override
    public List<NhanVien> findAll() {
        return repository.findAll();
    }

    @Override
    public List<NhanVien> findByTenCongViec(String tenCongViec) {
        return repository.findByTenCongViec(tenCongViec);
    }

    @Override
    public List<NhanVien> findByNgayLamVaNgayKetThuc(String ngayBatDauLam, String ngayKetThucLam) {
        return repository.findByNgayLamVaNgayKetThuc(ngayBatDauLam, ngayKetThucLam);
    }

    @Override
    public NhanVien selectNhanVien(int manv) {
        return repository.selectNhanVien(manv);
    }

    @Override
    public boolean deleteUser(int manv) throws SQLException {
        return repository.deleteUser(manv);
    }

}
