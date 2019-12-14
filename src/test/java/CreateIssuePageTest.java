import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class CreateIssuePageTest {

    private static WebDriver driver;

    @BeforeAll
    private static void init() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    private void initDriver() {
        driver = new FirefoxDriver();
    }

    @AfterEach
    private void closeDriver() {
        driver.close();
    }

    private void runSuccessTest(User user, Issue issue) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .login(user)
                .clickIssues()
                .clickCreateIssue()
                .createIssueSuccess(issue)
                .checkSuccessMessage("was reported");
    }

    private void runErrorTest(User user, Issue issue) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .login(user)
                .clickIssues()
                .clickCreateIssue()
                .createIssueError(issue)
                .checkErrorMessage("Summary is required");
    }

    @Test
    void createSimpleIssueSuccessTest() {
        driver.get("http://localhost:8080/login");
        User user = User.createValidUser();
        Issue issue = Issue.createValidOnelineIssue();

        runSuccessTest(user, issue);
    }

    @Test
    void createMultilineIssueSuccessTest() {
        driver.get("http://localhost:8080/login");
        User user = User.createValidUser();
        Issue issue = Issue.createValidMultilineIssue();

        runSuccessTest(user, issue);
    }

    @Test
    void createIssueWithEmptySummaryErrorTest() {
        driver.get("http://localhost:8080/login");
        User user = User.createValidUser();
        Issue issue = Issue.createWithEmptySummary();

        runErrorTest(user, issue);
    }

    @Test
    void createIssueEmptyErrorTest() {
        driver.get("http://localhost:8080/login");
        User user = User.createValidUser();
        Issue issue = Issue.createEmpty();

        runErrorTest(user, issue);
    }

    @Test
    void createIssueWithEmptyDescriptionSuccessTest() {
        driver.get("http://localhost:8080/login");
        User user = User.createValidUser();
        Issue issue = Issue.createWithEmptyDescription();

        runSuccessTest(user, issue);
    }

    @Test
    void createIssueWithLongSummarySuccessTest() {
        driver.get("http://localhost:8080/login");
        User user = User.createValidUser();
        Issue issue = Issue.createWithLongSummary();

        runSuccessTest(user, issue);
    }

    @Test
    void createIssueWithLongDescriptioSuccessTest() {
        driver.get("http://localhost:8080/login");
        User user = User.createValidUser();
        Issue issue = Issue.createWithLongDescription();

        runSuccessTest(user, issue);
    }

    @Test
    void createIssueWithSpecificSymbolsInSummarySuccessTest() {
        driver.get("http://localhost:8080/login");
        User user = User.createValidUser();
        Issue issue = Issue.createWithSpecificSummarySymbols();

        runSuccessTest(user, issue);
    }


    @Test
    void createIssueWithSpecificSymbolsInDescriptionSuccessTest() {
        driver.get("http://localhost:8080/login");
        User user = User.createValidUser();
        Issue issue = Issue.createWithSpecificDescriptionSymbols();

        runSuccessTest(user, issue);
    }
}