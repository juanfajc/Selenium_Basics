package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class HomePage {

    private WebDriverWait wait;
    private static int DEFAULT_GUESTS = 2;

    @FindBy(css = ".hotels")
    private WebElement hotelsActiveButton;

    @FindBy(css = "#s2id_autogen16")
    private WebElement locationClickableButton;

    @FindBy(css = "div.locationlistHotels")
    private WebElement locationHotelInput;

    @FindBy(css = "#select2-drop > ul.select2-results")
    private WebElement availableList;

    @FindBy(css = ".select2-result-sub > li")
    private List<WebElement> hotelsList;

    @FindBy(css = "#checkin")
    private WebElement checkInCalendar;

    @FindBy(xpath = "//div[@id='datepickers-container']/div[1]//div[@class='datepicker--cell datepicker--cell-day -current-']")
    private WebElement currentSelectDate;

    @FindBy(xpath = "//div[@id='datepickers-container']/div[2]//div[contains(@class, 'datepicker--cells-days')]/child::div")
    private List<WebElement> calendarAvailableDays;

    @FindBy(css = ".o2.col .bootstrap-touchspin-up")
    private WebElement addAdultButton;

    @FindBy(css = ".o2.col .bootstrap-touchspin-down")
    private WebElement lessAdultButton;

    @FindBy(xpath = "//div[@class='col 01']//button[@class='btn btn-white bootstrap-touchspin-up ']")
    private WebElement addChildrenButton;

    @FindBy(css = "form[name='HOTELS'] .col-lg-2 > .btn")
    private WebElement searchHotelReservationButton;

    @FindBy(css = ".heading-title")
    private WebElement getSearchTitle;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void hotelReservation() {
        hotelsActiveButton.isSelected();
    }

    public void getHotelForReservation(String hotel) {
        locationClickableButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(availableList));
        hotelsList.stream().findFirst().filter(webElement -> webElement.getText().contains(hotel)).get().click();
    }

    public void setCalendarAvailableDays(int days) {
        checkInCalendar.click();
        int currentDate = Integer.parseInt(wait.until(ExpectedConditions.elementToBeClickable(currentSelectDate)).getText());
        currentSelectDate.click();
        int finalDays = days + currentDate - 1;
        calendarAvailableDays.get(finalDays).click();
    }

    public void setNumberOfGuest(int adults, int children){
        if(adults == DEFAULT_GUESTS){
            setNumberOfChildren(children);
        }else {
            setNumberOfAdults(adults);
            setNumberOfChildren(children);
        }
    }

    public void searchAvailableHotel(){
        searchHotelReservationButton.click();
    }

    public String checkSearchTitle(){
        return getSearchTitle.getText();
    }

    public String validHotelName() {
        return locationHotelInput.getText();
    }

    private void setNumberOfAdults(int adults){
        if(adults > DEFAULT_GUESTS){
            do{
                addAdultButton.click();
                DEFAULT_GUESTS++;
            }while(adults != DEFAULT_GUESTS);
        } else if(adults < DEFAULT_GUESTS && adults > 0){
            lessAdultButton.click();
        }
    }

    private void setNumberOfChildren(int children){
        int defaultChildren = 0;
        if(children > defaultChildren){
            do {
                addChildrenButton.click();
                defaultChildren++;
            }while(children != defaultChildren);
        }
    }
}
