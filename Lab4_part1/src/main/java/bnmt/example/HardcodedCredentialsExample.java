package bnmt.example;

import java.security.MessageDigest;
import java.util.Scanner;

class SecureCredentialsExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        // Giả sử thông tin hợp lệ được lấy từ biến môi trường
        String storedUser = System.getenv("APP_USERNAME");
        String storedHash = System.getenv("APP_PASSWORD_HASH");

        if (storedUser == null || storedHash == null) {
            System.err.println("Error: Environment variables not set.");
            return;
        }

        if (authenticate(username, password, storedUser, storedHash)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }

    private static boolean authenticate(String user, String pass, String validUser, String validHash) {
        return user.equals(validUser) && hashPassword(pass).equals(validHash);
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}
