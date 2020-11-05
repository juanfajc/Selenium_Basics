package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//img[@alt='Login']")
    private WebElement homeIconPage;

    @FindBy(css = ".d-flex > h3")
    private WebElement loginIcon;

    @FindBy(css = "input[name='username']")
    private WebElement userNameLogin;

    @FindBy(css = "[name='password']")
    private WebElement passwordLogin;

    @FindBy(css = ".loginbtn")
    private WebElement loginButton;

    @FindBy(css = ".d-flex > h3")
    private WebElement loginTitle;

    @FindBy(css = ".btn-success")
    private WebElement signUpButton;

    @FindBy(css = ".btn-warning")
    private WebElement forgetPasswordButton;

    @FindBy(css = ".alert-success")
    private WebElement loginSuccess;

    @FindBy(css = ".alert-danger")
    private WebElement loginAlert;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginToTravelAccount(String user, String password) {
        homeIconPage.isDisplayed();
        userNameLogin.sendKeys(user);
        passwordLogin.sendKeys(password);
        loginButton.click();
    }

    public String loginAlertMessage(){
        return loginAlert.getText();
    }

    public String getLoginTitle(){
        return loginTitle.getText();
    }

}
