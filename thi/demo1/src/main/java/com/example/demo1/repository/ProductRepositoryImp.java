package com.example.demo1.repository;

import com.example.demo1.model.Category;
import com.example.demo1.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.demo1.util.ConnectionUtils.getConnection;

public class ProductRepositoryImp implements ProductRepository {
    private static final String DELETE_PRODUCT_SQL = "delete from product where stt = ?;";
    private CategoryRepository categoryRepository = new CategoryRepositoryImp();

    private static final String SELECT_ALL_PRODUCT = "select *\n" +
            "from product \n" +
            "\tjoin category on product.categoryid = category.categoryid;";
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product(name, price, quantity, " +
            "color, categoryid) VALUES ( ?, ?, ?, ?, ?)";
    private static final String UPDATE_PRODUCT_SQL = "update product set name = ?,price= ?, quantity =?, color =?, categoryid =? where stt = ?;";

    private static final String SELECT_PRODUCT_BY_STT = "Select * from product where stt = ?";
    private static final String SEARCH_ALL_CATEGORYNAME = "select * \n" +
            "from product as p join category c on p.categoryid=c.categoryid\n" +
            "where categoryname like ? ";

    @Override
    public void add(Product product) {
        System.out.println(INSERT_PRODUCT_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getCategory().getIdCategory());
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
    public void update(Product product) {
        System.out.println(UPDATE_PRODUCT_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getCategory().getIdCategory());
            preparedStatement.setInt(6, product.getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("stt");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                Double quantity = rs.getDouble("quantity");
                String color = rs.getString("color");
                String categoryid = rs.getString("categoryid");
                Category category = categoryRepository.findById(categoryid);
                productList.add(new Product(id, name, price, quantity, color, category));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return productList;
    }

    @Override
    public List<Product> findByTenProduct(String categoryname) throws SQLException {
        List<Product> productList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_ALL_CATEGORYNAME)
        ) {
            preparedStatement.setString(1, categoryname + "%");
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("stt");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                Double quantity = rs.getDouble("quantity");
                String color = rs.getString("color");
                String categoryid = rs.getString("categoryid");
                Category category = categoryRepository.findById(categoryid);
                productList.add(new Product(id, name, price, quantity, color, category));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return productList;
    }

    @Override
    public Product selectNhanVien(int id) {
        Product product = null;
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_STT);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int stt = rs.getInt("stt");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                Double quantity = rs.getDouble("quantity");
                String color = rs.getString("color");
                String categoryid = rs.getString("categoryid");
                Category category = categoryRepository.findById(categoryid);
                product = new Product(stt,name,price,quantity,color,category);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
