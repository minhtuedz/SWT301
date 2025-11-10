package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    private final String URL = "https://demoqa.com/automation-practice-form";

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        navigateTo(URL);
    }

    private void hideAds() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            // Ẩn tất cả iframe quảng cáo để không che element
            js.executeScript(
                    "let ads = document.querySelectorAll('iframe');" +
                            "ads.forEach(ad => ad.style.display='none');"
            );
        } catch (Exception e) {
            // Nếu không có iframe thì bỏ qua
        }
    }

    public void fillForm(String firstName, String lastName, String email, String gender,
                         String phone, String subject, String hobbies, String picturePath,
                         String address, String state, String city) {

        // ==== Bước 4: ẩn tất cả iframe quảng cáo Google Ads ====
        ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('iframe[id^=\"google_ads_iframe\"]').forEach(e => e.style.display='none');"
        );

        if (firstName != null) type(By.id("firstName"), firstName);
        if (lastName != null) type(By.id("lastName"), lastName);
        if (email != null) type(By.id("userEmail"), email);

        if (gender != null && !gender.isEmpty())
            click(By.xpath("//label[text()='" + gender + "']"));

        if (phone != null) type(By.id("userNumber"), phone);

        if (subject != null && !subject.isEmpty()) {
            WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
            subjectInput.sendKeys(subject);
            subjectInput.sendKeys(Keys.ENTER);
        }

        if (hobbies != null && !hobbies.isEmpty())
            click(By.xpath("//label[text()='" + hobbies + "']"));

        if (picturePath != null && !picturePath.isEmpty())
            driver.findElement(By.id("uploadPicture")).sendKeys(picturePath);

        if (address != null) type(By.id("currentAddress"), address);

        if (state != null && !state.isEmpty()) {
            WebElement stateInput = driver.findElement(By.id("react-select-3-input"));
            stateInput.sendKeys(state);
            stateInput.sendKeys(Keys.ENTER);
        }

        if (city != null && !city.isEmpty()) {
            WebElement cityInput = driver.findElement(By.id("react-select-4-input"));
            cityInput.sendKeys(city);
            cityInput.sendKeys(Keys.ENTER);
        }
    }

    public void submitForm() {
        click(By.id("submit"));
    }

    public boolean isSubmissionModalDisplayed() {
        try {
            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
            return modal.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void register(String firstName, String lastName, String email, String gender,
                         String phone, String subject, String hobbies, String picturePath,
                         String address, String state, String city) {
        fillForm(firstName, lastName, email, gender, phone, subject, hobbies, picturePath, address, state, city);
        submitForm();
    }
}
