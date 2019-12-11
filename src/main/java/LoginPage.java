import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private String url = "http://localhost:8080/login";

    private WebDriver driver;

    @FindBy(id = "id_l.L.login")
    private WebElement login;

    @FindBy(id = "id_l.L.password")
    private WebElement password;

    @FindBy(id = "id_l.L.loginButton")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public DashboardPage login(User user) {
        this.login.sendKeys(user.login);
        this.password.sendKeys(user.password);
        loginButton.click();
        return new DashboardPage(driver);
    }
}
