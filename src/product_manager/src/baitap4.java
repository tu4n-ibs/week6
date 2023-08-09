package product_manager.src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class baitap4 {
    public static void main(String[] args) {
        product_manager productManager = new product_manager();
        Connection connection = productManager.connect();

        String query = "delete from products where id = ?";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,3);

            int row = preparedStatement.executeUpdate();
            if (row!=0) System.out.println("xoa thanh cong : " + row);

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
