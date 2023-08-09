package thuchanh5;

import thuchanh1.ConnectJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection = connectJDBC.ConnectJDBC();

        String query = "delete from users where id = ?";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 5);

            int row = preparedStatement.executeUpdate();
            if (row != 0) System.out.println("xoa thanh cong: " + row);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
