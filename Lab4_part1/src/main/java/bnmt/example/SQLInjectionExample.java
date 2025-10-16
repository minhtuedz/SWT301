package bnmt.example;

import java.sql.*;

public class SQLInjectionExample {
    public static void main(String[] args) {
        String userInput = "' OR '1'='1"; // input nguy hiểm từ user

        // Thay bằng cấu hình thật khi chạy
        String jdbcUrl = "jdbc:mysql://localhost:3306/mydb";
        String dbUser  = "your_user";
        String dbPass  = "your_pass";

        String sql = "SELECT * FROM users WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, userInput);               // gán tham số an toàn
            System.out.println("Executing parameterized query (username = ?).");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println("Found user: " + rs.getString("username"));
                }
            }

        } catch (SQLException e) {
            System.err.println("DB error: " + e.getMessage());
        }
    }
}
