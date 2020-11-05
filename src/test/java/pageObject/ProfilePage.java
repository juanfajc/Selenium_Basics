package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProfilePage {

    @FindBy(css = ".text-align-left")
    private WebElement welcomeTitle;

    @FindBy(css = "a[title='home']")
    private WebElement homeButton;

    @FindBy(css = ".col-md-4 > .img-responsive")
    private WebElement pictureProfile;

    @FindBy(css = "div.dropdown-login > #dropdownCurrency")
    private WebElement userButton;

    @FindBy(css = ".dropdown-menu > div> .dropdown-item.tr")
    private List<WebElement> menuButton;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String checkLoginProfileSuccess() {
        return welcomeTitle.getText();
    }

    public void logoutProfile() {
        homeButton.isDisplayed();
        userButton.click();
        getLogoutOption();
    }

    public void goHomePage(){
        homeButton.click();
    }

    private void getLogoutOption() {
        menuButton.stream().filter(webElement -> webElement.getText().matches("Logout")).forEach(WebElement::click);
    }

}
