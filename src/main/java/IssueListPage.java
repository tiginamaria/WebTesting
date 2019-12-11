import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class IssueListPage {

    private WebDriver driver;

    @FindBy(id = "id_l.D.h.header")
    private WebElement header;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/a[5]")
    private WebElement createIssueButton;

    @FindBy(id = "__popup__1")
    private WebElement createIssueSuccess;

    private List<Issue> issues = new ArrayList<>();

    public IssueListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CreateIssuePage clickCreateIssue() {
        createIssueButton.click();
        return new CreateIssuePage(driver);
    }

    /**
     * Check success message after create right issue
     *
     * @param successMessage - success message
     * @return {@link IssueListPage}
     */
    public IssueListPage checkSuccessMessage(String successMessage) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(driver -> createIssueSuccess.isDisplayed());
        Assert.assertTrue("Success message should be present",
                createIssueSuccess.isDisplayed());
        Assert.assertTrue("Success message should contains " + successMessage,
                createIssueSuccess.getText().contains(successMessage));
        return this;
    }
}
