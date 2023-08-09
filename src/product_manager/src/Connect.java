package product_manager.src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connect {
    public static void main(String[] args) {
        product_manager productManager = new product_manager();
        Connection connection = productManager.connect();
        String query = "insert into products(id,name,price,detail,manufacturer,number,status)" + "values (?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = null;

        String [] array = new String[14];
        try {
            for (int i = 0; i <= array.length; i++) {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, +i);
                preparedStatement.setString(2, "samsung2");
                preparedStatement.setInt(3, 500000);
                preparedStatement.setString(4, "ngon, bo, re");
                preparedStatement.setString(5, "samsung3");
                preparedStatement.setInt(6, 7);
                preparedStatement.setString(7, "khong");
            }
            int row = preparedStatement.executeUpdate();
            if (row != 0) System.out.println("them thanh cong: " + row);
            connection.close();
        } catch(
                SQLException e)

        {
            throw new RuntimeException(e);
        }
    }
}
