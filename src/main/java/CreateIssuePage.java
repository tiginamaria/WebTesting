import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateIssuePage {

    private WebDriver driver;

    @FindBy(id = "id_l.I.ni.ei.eit.summary")
    private WebElement summary;

    @FindBy(id = "id_l.I.ni.ei.eit.description")
    private WebElement description;

    @FindBy(id = "id_l.I.ni.ei.submitButton_74_4")
    private WebElement submitIssue;

    @FindBy(id = "__popup__1")
    private WebElement createIssueError;

    public CreateIssuePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Create new issue
     *
     * @param issue - {@link Issue}
     */
    private void createIssue(Issue issue) {
        System.out.println(driver.getTitle());
        summary.sendKeys(issue.summary);
        description.sendKeys(issue.description);

        submitIssue.click();
    }

    /**
     * Successful create issue
     *
     * @param issue - {@link Issue}
     * @return {@link CreateIssuePage}
     */
    public IssueListPage createIssueSuccess(Issue issue) {
        createIssue(issue);
        return new IssueListPage(driver);
    }

    /**
     * Error create issue
     *
     * @param issue - {@link Issue}
     * @return {@link IssueListPage}
     */
    public CreateIssuePage createIssueError(Issue issue) {
        createIssue(issue);
        return this;
    }

    /**
     * Check error message after create wrong issue
     *
     * @param errorMessage - error message
     * @return {@link CreateIssuePage}
     */
    public CreateIssuePage checkErrorMessage(String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(driver -> createIssueError.isDisplayed());
        Assert.assertTrue("Error message should be present",
                createIssueError.isDisplayed());
        Assert.assertTrue("Error message should contains " + errorMessage,
                createIssueError.getText().contains(errorMessage));
        return this;
    }
}
