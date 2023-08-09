package product_manager.src;

import java.sql.*;

public class baitap5 {
    public static void main(String[] args) {
        product_manager productManager = new product_manager();
        Connection connection = productManager.connect();

        String query1 = "select * from products";
        String query2 = "select * from products where id = 2";
        String query3 = "select * from products where id = 10 or id = 2";
        String query4 = "select * from products where status = '0' ";
        String query5 = "select * from products where status = '0' and number = 20";

        Statement statement = null;
        System.out.println("query1");
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query1);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String detail = rs.getString("detail");
                String manufacturer = rs.getString("manufacturer");
                int number = rs.getInt("number");
                String status = rs.getString("status");

                System.out.println("-id: " + id + " -name: " + name + " -price: " + price + " -detail: " + detail
                        + " -manufacturer: " + manufacturer + " -number: " + number + " -status: " + status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("query2");
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query2);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String detail = rs.getString("detail");
                String manufacturer = rs.getString("manufacturer");
                int number = rs.getInt("number");
                String status = rs.getString("status");

                System.out.println("-id: " + id + " -name: " + name + " -price: " + price + " -detail: " + detail
                        + " -manufacturer: " + manufacturer + " -number: " + number + " -status: " + status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("query3");
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query3);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String detail = rs.getString("detail");
                String manufacturer = rs.getString("manufacturer");
                int number = rs.getInt("number");
                String status = rs.getString("status");

                System.out.println("-id: " + id + " -name: " + name + " -price: " + price + " -detail: " + detail
                        + " -manufacturer: " + manufacturer + " -number: " + number + " -status: " + status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("query4");
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query4);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String detail = rs.getString("detail");
                String manufacturer = rs.getString("manufacturer");
                int number = rs.getInt("number");
                String status = rs.getString("status");

                System.out.println("-id: " + id + " -name: " + name + " -price: " + price + " -detail: " + detail
                        + " -manufacturer: " + manufacturer + " -number: " + number + " -status: " + status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("query5");
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query5);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String detail = rs.getString("detail");
                String manufacturer = rs.getString("manufacturer");
                int number = rs.getInt("number");
                String status = rs.getString("status");

                System.out.println("-id: " + id + " -name: " + name + " -price: " + price + " -detail: " + detail
                        + " -manufacturer: " + manufacturer + " -number: " + number + " -status: " + status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
