package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Register Tests using CSV")
class RegisterTest extends BaseTest {

    static RegisterPage registerPage;

    @BeforeAll
    public static void initPage() {
        registerPage = new RegisterPage(driver);
    }

    @ParameterizedTest(name = "{0} {1} -> {11}")
    @Order(1)
    @CsvFileSource(resources = "/register-data.csv", numLinesToSkip = 1)
    void testRegisterFromCSV(String firstName, String lastName, String email, String gender,
                             String phone, String subject, String hobbies, String picturePath,
                             String address, String state, String city, String expectedResult) {

        registerPage.navigate();

        registerPage.register(firstName, lastName, email, gender, phone, subject, hobbies, picturePath, address, state, city);

        boolean isModalDisplayed = registerPage.isSubmissionModalDisplayed();

        if ("success".equalsIgnoreCase(expectedResult)) {
            assertTrue(isModalDisplayed, "Expected success modal not displayed for: " + firstName + " " + lastName);
        } else {
            assertTrue(!isModalDisplayed, "Expected failure but modal displayed for: " + firstName + " " + lastName);
        }
    }
}
