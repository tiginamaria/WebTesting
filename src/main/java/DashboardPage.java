import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/a[2]/span")
    private WebElement issuesButton;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public IssueListPage clickIssues() {
        issuesButton.click();
        return new IssueListPage(driver);
    }
}
