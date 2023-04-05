package com.example.demo1.repository;

import com.example.demo1.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo1.util.ConnectionUtils.getConnection;

public class CategoryRepositoryImp implements CategoryRepository{
    private static final String SELECT_ALL_CATEGORY = "Select * from category";
    private static final String SELECT_CATEGORY_BY_ID = "Select * from category where categoryid = ?";
    @Override
    public Category findById(String idCategory) {
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1,idCategory);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            if (rs.next()) {
                String nameCategory = rs.getString("categoryname");
                return new Category(idCategory, nameCategory);
            }
        } catch (SQLException e) {
            printSQLException(e);
            throw new RuntimeException(e);
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

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String idCategory = rs.getString("categoryid");
                String nameCategory = rs.getString("categoryname");
                categoryList.add(new Category(idCategory,nameCategory));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categoryList;
    }
}
