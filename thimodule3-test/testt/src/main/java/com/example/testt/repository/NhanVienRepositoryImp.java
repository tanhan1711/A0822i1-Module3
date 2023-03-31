package com.example.testt.repository;

import com.example.testt.bean.CongViec;
import com.example.testt.bean.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.example.testt.util.ConnectionUtils.getConnection;

public class NhanVienRepositoryImp implements NhanVienRepository{
    private static final String DELETE_USERS_SQL = "delete from nhanvien where manv = ?;";
    private CongViecRepository congViecRepository = new CongViecRepositoryImp();

    private static final String SELECT_ALL_NHAN_VIEN = "select *\n" +
            "from nhanvien \n" +
            "\tjoin congviec on nhanvien.macv = congviec.macv;";
    private static final String INSERT_USERS_SQL = "INSERT INTO nhanvien(tennv, ngaysinh, diachi, " +
            "ngaybatdau, ngayketthuc, luong, macv) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USERS_SQL = "update nhanvien set tennv = ?,ngaysinh= ?, diachi =?, ngaybatdau =?, ngayketthuc =?, luong =?, macv =? where manv = ?;";

    private static final String SELECT_NHAN_VIEN_BY_MANV = "Select * from nhanvien where manv = ?";
    private static final String SEARCH_ALL_TENCV = "select * \n" +
            "from nhanvien as nv join congviec cv on nv.macv =cv.macv\n" +
            "where tencv like ? ";
    @Override
    public void add(NhanVien nhanVien) {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
//            preparedStatement.setInt(1, nhanVien.getMaNhanVien());
            preparedStatement.setString(1, nhanVien.getHoTen());
            preparedStatement.setDate(2, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
            preparedStatement.setString(3, nhanVien.getDiaChi());
            preparedStatement.setDate(4, new java.sql.Date(nhanVien.getNgayBatDauLam().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(nhanVien.getNgayKetThucLam().getTime()));
            preparedStatement.setDouble(6, nhanVien.getLuong());
            preparedStatement.setString(7, nhanVien.getMaCongViec().getMaCongViec());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
            throw new RuntimeException(e);
        }

    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    @Override
    public void update(NhanVien nhanVien) {
        System.out.println(UPDATE_USERS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setString(1, nhanVien.getHoTen());
            preparedStatement.setDate(2, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
            preparedStatement.setString(3, nhanVien.getDiaChi());
            preparedStatement.setDate(4, new java.sql.Date(nhanVien.getNgayBatDauLam().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(nhanVien.getNgayKetThucLam().getTime()));
            preparedStatement.setDouble(6, nhanVien.getLuong());
            preparedStatement.setString(7, nhanVien.getMaCongViec().getMaCongViec());
            preparedStatement.setInt(8, nhanVien.getMaNhanVien());

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

        @Override
    public List<NhanVien> findAll() {
        List<NhanVien> nhanVienList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NHAN_VIEN)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maNhanVien = rs.getInt("manv");
                String hoTen = rs.getString("tennv");
                Date ngaySinh = new Date(rs.getDate("ngaysinh").getTime());
                String diaChi = rs.getString("diachi");
                Date ngayBatDauLam = new Date(rs.getDate("ngaybatdau").getTime());
                Date ngayKetThucLam = new Date(rs.getDate("ngayketthuc").getTime());
                double luong = rs.getDouble("luong");
                String maCongViec = rs.getString("macv");
                CongViec congViec = congViecRepository.findById(maCongViec);
                nhanVienList.add(new NhanVien(maNhanVien, hoTen, ngaySinh, diaChi, ngayBatDauLam, ngayKetThucLam, luong, congViec));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return nhanVienList;

    }

    @Override
    public List<NhanVien> findByTenCongViec(String tenCongViec) {

        List<NhanVien> nhanVienList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_ALL_TENCV)
        ) {  preparedStatement.setString(1,tenCongViec+"%");
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maNhanVien = rs.getInt("manv");
                String hoTen = rs.getString("tennv");
                Date ngaySinh = new Date(rs.getDate("ngaysinh").getTime());
                String diaChi = rs.getString("diachi");
                Date ngayBatDauLam = new Date(rs.getDate("ngaybatdau").getTime());
                Date ngayKetThucLam = new Date(rs.getDate("ngayketthuc").getTime());
                double luong = rs.getDouble("luong");
                String maCongViec = rs.getString("macv");
                CongViec congViec = congViecRepository.findById(maCongViec);
                nhanVienList.add(new NhanVien(maNhanVien, hoTen, ngaySinh, diaChi, ngayBatDauLam, ngayKetThucLam, luong, congViec));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return nhanVienList;

    }

    @Override
    public List<NhanVien> findByNgayLamVaNgayKetThuc(String ngayBatDauLam, String ngayKetThucLam) {
        return null;
    }

    @Override
    public NhanVien selectNhanVien(int manv) {
        NhanVien nhanVien = null;
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NHAN_VIEN_BY_MANV);) {
            preparedStatement.setInt(1, manv);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int maNhanVien = rs.getInt("manv");
                String hoTen = rs.getString("tennv");
                Date ngaySinh = new Date(rs.getDate("ngaysinh").getTime());
                String diaChi = rs.getString("diachi");
                Date ngayBatDauLam = new Date(rs.getDate("ngaybatdau").getTime());
                Date ngayKetThucLam = new Date(rs.getDate("ngayketthuc").getTime());
                double luong = rs.getDouble("luong");
                String maCongViec = rs.getString("macv");
                CongViec congViec = congViecRepository.findById(maCongViec);

                nhanVien = new NhanVien(maNhanVien,hoTen,ngaySinh,diaChi,ngayBatDauLam,ngayKetThucLam,luong,congViec);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return nhanVien;
    }


    public boolean deleteUser(int manv) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, manv);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
