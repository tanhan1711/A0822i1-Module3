package com.example.demo1.repository;

import com.example.demo1.model.Congviec;
import com.example.demo1.model.Nhanvien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanvienRepo implements INhanvienRepo {
    private static final String INSERT_NHANVIEN_SQL = "insert into nhanvien values (?, ?, ?, ?, ?, ?,?,?)";
    String SELECT_ALL_FROM_NHANVIEN = "Select * from nhanvien";
    String FIND_NHANVIEN_BY_MANV = "select * from nhanvien where manv = ?";
    String FIND_CONGVIEC_BY_MACV = "select * from congviec where macv = ?";
    String FIND_ALL_CONGVIEC = "select * from congviec";

    private static String jdbcURL = "jdbc:mysql://localhost:3306/module3thi?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "17112000";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void insertUser(Nhanvien nhanvien) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NHANVIEN_SQL)) {
            preparedStatement.setInt(1, nhanvien.getManv());
            preparedStatement.setString(2, nhanvien.getTennv());
            preparedStatement.setDate(3, new java.sql.Date(nhanvien.getNgaysinh().getTime()));
            preparedStatement.setString(4, nhanvien.getDiachi());
            preparedStatement.setDate(5, new java.sql.Date(nhanvien.getNgaybatdau().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(nhanvien.getNgayketthuc().getTime()));
            preparedStatement.setDouble(7, nhanvien.getLuong());
            preparedStatement.setString(8, nhanvien.getCongviec().getMacv());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException e) {
    }

    @Override
    public Nhanvien selectUser(int manv) {
        return null;
    }

    @Override
    public List<Nhanvien> selectAllUsers() {
        List<Nhanvien> nhanviens = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_NHANVIEN);
            {
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int manv = rs.getInt("manv");
                    String tennv = rs.getString("tennv");
                    Date ngaysinh = rs.getDate("ngaysinh");
                    String diachi = rs.getString("diachi");
                    Date ngaybatdau = rs.getDate("ngaybatdau");
                    Date ngayketthuc = rs.getDate("ngayketthuc");
                    Double luong = rs.getDouble("luong");
                    String macv = rs.getString("macv");
                    Congviec cv = new Congviec();
                    cv.setMacv(macv);
                    nhanviens.add(new Nhanvien(manv, tennv, ngaysinh, diachi, ngaybatdau, ngayketthuc, luong, cv));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nhanviens;
    }
        @Override
    public boolean deleteUser(int manv) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(Nhanvien nhanvien) throws SQLException {
        return false;
    }

    @Override
    public List<Nhanvien> findBytencv(String tencv) throws SQLException {
        return null;
    }
}
