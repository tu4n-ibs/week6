package product_manager.src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class baitap3 {
    public static void main(String[] args) {
        product_manager productManager = new product_manager();
        Connection connection = productManager.connect();

        String query1 = " update products set detail = ? where id = 3 ";
        String query2 = " update products set manufacturer = ?,price = ? where id = 2 ";
        String query3 = " update products set number = ?, status = ? where id = 1 ";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setString(1,"du lieu moi");

            int row = preparedStatement.executeUpdate();
            if (row!=0) System.out.println("cap nhap thanh cong: " + row);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            preparedStatement = connection.prepareStatement(query2);
            preparedStatement.setString(1,"apple");
            preparedStatement.setInt(2,12000000);

            int row = preparedStatement.executeUpdate();
            if (row!=0) System.out.println("cap nhap thanh cong: " + row);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {

            preparedStatement = connection.prepareStatement(query3);
            preparedStatement.setInt(1,20);
            preparedStatement.setString(2,"0");

            int row = preparedStatement.executeUpdate();
            if (row!=0) System.out.println("cap nhap thanh cong: " + row);

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
