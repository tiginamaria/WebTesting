import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class CreateIssuePageTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    private static void init() {
        System.setProperty("webdriver.gecko.driver","/home/maria/Загрузки/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    void createIssueSuccessTest() {
        driver.get("http://localhost:8080/login");
        User user = User.createValidUser();
        Issue issue = Issue.createValidIssue();

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .login(user)
                .clickIssues()
                .clickCreateIssue()
                .createIssueSuccess(issue)
                .checkSuccessMessage("was reported");
    }

    @Test
    void createIssueWithoutSummaryErrorTest() {
        driver.get("http://localhost:8080/login");
        User user = User.createValidUser();
        Issue issue = Issue.createIssueWithoutSummary();

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .login(user)
                .clickIssues()
                .clickCreateIssue()
                .createIssueError(issue)
                .checkErrorMessage("Summary is required");
    }

    @Test
    void createIssueWithLongSummarySuccessTest() {
        driver.get("http://localhost:8080/login");
        User user = User.createValidUser();
        Issue issue = Issue.createIssueWithLongSummary();

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .login(user)
                .clickIssues()
                .clickCreateIssue()
                .createIssueSuccess(issue)
                .checkSuccessMessage("was reported");
    }

    @Test
    void createIssueWithSpecificSymbolsSuccessTest() {
        driver.get("http://localhost:8080/login");
        User user = User.createValidUser();
        Issue issue = Issue.createIssueWithSpecificSymbols();

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .login(user)
                .clickIssues()
                .clickCreateIssue()
                .createIssueSuccess(issue)
                .checkSuccessMessage("was reported");
    }
}