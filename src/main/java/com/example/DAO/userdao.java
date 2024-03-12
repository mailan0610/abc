package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.DTO.AccountDTO;

public class userdao {
    public static boolean login(AccountDTO account)
    {
        int result = 0;
            try {
                Connection conn = Database.getConnection();
                String sql = "insert into product (name, pass) values (?, ?)";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, account.getUsername());
                pst.setString(2, account.getPassword());
                result = pst.executeUpdate();
                if (result > 0) {
                    return true;
                }
                Database.closeConnection(conn);
            } catch (Exception e) {
                return false;
            }
            return false;
    }
    public static String getProduct() {
        StringBuilder result = new StringBuilder();

        try {
            Connection conn = Database.getConnection();
            String sql = "SELECT * FROM user";
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet resultSet = pst.executeQuery();

            // Duyệt qua kết quả và thêm vào chuỗi
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                result.append("Username: ").append(username).append(", Password: ").append(password).append("\n");
            }

            // Đóng tài nguyên
            Database.closeConnection(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}

    // public static boolean createAccount(String username, String password) {
    //     int result = 0;
    //     try {
    //         Connection conn = Database.getConnection();
    //         String sql = "insert into account (username, password) values (?, ?)";
    //         PreparedStatement pst = conn.prepareStatement(sql);
    //         pst.setString(1, username);
    //         pst.setString(2, password);
    //         result = pst.executeUpdate();
    //         if (result > 0) {
    //             return true;
    //         }
    //         mysqlConnect.closeConnection(conn);
    //     } catch (Exception e) {
    //         return false;
    //     }
    //     return false;
    // }
