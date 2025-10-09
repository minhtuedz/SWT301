package bnmt.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountServiceTest {

    private final AccountService accountService = new AccountService();

    @ParameterizedTest(name = "Test {index} => username={0}, password={1}, email={2}, expected={3}")
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    @DisplayName("Test registerAccount() with data CSV")
    void testRegisterAccount(String username, String password, String email, boolean expected) {
        boolean actual = accountService.registerAccount(username, password, email);
        assertEquals(expected, actual,
                () -> "Register result for username=" + username + " should be " + expected);
    }

    @ParameterizedTest(name = "Test {index} => email={2} expected={3}")
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    @DisplayName("Test isValidEmail() with data CSV")
    void testIsValidEmail(String username, String password, String email, boolean expected) {
        // Kết quả mong đợi của email chỉ phụ thuộc vào email hợp lệ hay không
        boolean emailValid = accountService.isValidEmail(email);

        // Nếu email không hợp lệ thì chắc chắn registerAccount phải false
        if (!emailValid) {
            assertEquals(false, expected,
                    () -> "Email " + email + " is invalid => expected=false");
        }

        // Kiểm tra hàm isValidEmail() độc lập
        boolean expectedEmailValid = email.contains("@") && email.contains(".");
        assertEquals(expectedEmailValid, emailValid,
                () -> "Email validation failed for: " + email);
    }
}
