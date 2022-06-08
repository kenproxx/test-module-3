package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    //list product


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo2006?useSSL=false", "root", "123456");
        } catch (SQLException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        return connection;
    }

    public ProductService() {
    }
//show, find by name,  find by price


    public List<Product> findByName(String name1) {
        Connection connection = getConnection();
        List<Product> listProduct = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where name like  ?");
            preparedStatement.setString(1, "%" + name1 + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name2 = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                listProduct.add(new Product(id, name2, price, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return list
        return listProduct;

    }

    public List<Product> findByPrice(int priceStart, int priceEnd) {
        Connection connection = getConnection();
        List<Product> listProduct = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where price between ? and ?");
            preparedStatement.setInt(1, priceStart);
            preparedStatement.setInt(2, priceEnd);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                listProduct.add(new Product(id, name, price, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return list
        return listProduct;
    }

    public List<Product> showAll() {
        List<Product> listProduct = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                listProduct.add(new Product(id, name, price, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return list
        return listProduct;
    }
}
