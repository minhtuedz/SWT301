package bnmt.example;

import java.util.regex.Pattern;

public class AccountService {

    // Regex kiểm tra email hợp lệ
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$");

    /**
     * Đăng ký tài khoản
     * - username không được rỗng
     * - password dài hơn 6 ký tự
     * - email hợp lệ
     */
    public boolean registerAccount(String username, String password, String email) {
        if (username == null || username.isBlank()) {
            return false;
        }
        if (password == null || password.length() <= 6) {
            return false;
        }
        if (!isValidEmail(email)) {
            return false;
        }
        return true; // Nếu tất cả điều kiện đều đúng
    }

    /**
     * Kiểm tra email có hợp lệ hay không
     */
    public boolean isValidEmail(String email) {
        if (email == null) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
