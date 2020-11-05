package testsCases;

import common.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.LoginPage;

public class LoginTest extends Base {

    @Test(priority = 1)
    public void ValidIncorrectLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToTravelAccount("user@phptravels.com", "12345");
        Assert.assertEquals(loginPage.loginAlertMessage(), "Invalid Email or Password");
    }
}
