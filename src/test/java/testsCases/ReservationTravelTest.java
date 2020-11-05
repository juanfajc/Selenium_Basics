package testsCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import common.Base;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProfilePage;

public class ReservationTravelTest extends Base {

    private LoginPage loginPage;
    private ProfilePage profilePage;
    private HomePage homePage;

    @Test(priority = 0)
    public void LoginProfile() {
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        loginPage.loginToTravelAccount("user@phptravels.com", "demouser");
        Assert.assertEquals(profilePage.checkLoginProfileSuccess(), "Hi, Demo User");
    }

    @Test(priority = 1)
    public void HotelReservation() {
        homePage = new HomePage(driver);
        profilePage.goHomePage();
        homePage.hotelReservation();
        homePage.getHotelForReservation("Alzer Hotel");
        Assert.assertEquals(homePage.validHotelName(), "Alzer Hotel Istanbul, Istanbul");
        homePage.setCalendarAvailableDays(4);
        homePage.setNumberOfGuest(4, 1);
        homePage.searchAvailableHotel();
        Assert.assertEquals(homePage.checkSearchTitle(), "Hotels Alzer-Hotel-Istanbuls");
    }

    @Test(priority = 2)
    public void LogoutProfile(){
        profilePage.logoutProfile();
        Assert.assertEquals(loginPage.getLoginTitle(), "Login");
    }

}
