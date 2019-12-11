import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    private static void init() {
        System.setProperty("webdriver.gecko.driver","/home/maria/Загрузки/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    void loginTest() {
        driver.get("http://localhost:8080/login");
        User user = User.createValidUser();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
    }
}