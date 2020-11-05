# Travel automation

This is a project with Selenium Webdriver and Page factory. It has several features that a Automation Engineer can apply in a normal project. 

## Installation

Don't forget to update the pom.xml and synchronize the libraries

## Usage

Go to travel-automation\testng.xml to set up the test. Also you can add the value for each test like:

```Selenium
loginPage.loginToTravelAccount("user@phptravels.com", "demouser");
homePage.getHotelForReservation("Alzer Hotel");
homePage.setNumberOfGuest(4, 1);
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
