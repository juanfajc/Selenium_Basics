package common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.io.IOException;

public class Base {

    protected static WebDriver driver;

    @BeforeClass
    public void setUp() throws IOException {
        BrowserFactory browserFactory = new BrowserFactory();
        browserFactory.getBrowserDefault();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
