package com.example.demo1.repository;

import com.example.demo1.model.Congviec;

import java.sql.*;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class CongviecRepo implements ICongviecRepo{
    private static String jdbcURL = "jdbc:mysql://localhost:3306/module3thi?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "17112000";
    private static final String SELECT_CONG_VIEC_BY_ID = "Select * from Cong_Viec where ma_cong_viec = ?";
    ;

    @Override
    public void insertUser(Congviec congviec) throws SQLException {

    }

    @Override
    public Congviec selectUser(int macv) {
        return null;
    }

    @Override
    public List<Congviec> selectAllUsers() {
        return null;
    }

    @Override
    public boolean deleteUser(int macv) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(Congviec congviec) throws SQLException {
        return false;
    }

    @Override
    public List<Congviec> findBytencv(String tencv) throws SQLException {
        return null;
    }

    @Override
    public Congviec findById(String maCongViec) {
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONG_VIEC_BY_ID)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, maCongViec);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            if (rs.next()) {
                String tenCongViec = rs.getString("tencv");
                double luongThapNhat = rs.getDouble("luongthap");
                double luongCaoNhat = rs.getDouble("luongcap");
                return new Congviec(maCongViec, tenCongViec, luongThapNhat, luongCaoNhat);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;

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


    private Connection getConnection() {
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
    }
