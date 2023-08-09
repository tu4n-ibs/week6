package baitap2.src;

import thuchanh1.ConnectJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUsers {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection = connectJDBC.ConnectJDBC();

        String query = "insert into users(id,username,password,email)" + "values (?,?,?,?)";

        PreparedStatement prepared = null;

        try {
            prepared = connection.prepareStatement(query);
            prepared.setString(1,"8");
            prepared.setString(2, "Vuong Van Tuan");
            prepared.setString(3, "11111");
            prepared.setString(4, "TuanVuong3@codegym.vn");

            int row = prepared.executeUpdate();
            if (row != 0) {
                System.out.println("them thanh cong: " + row);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
