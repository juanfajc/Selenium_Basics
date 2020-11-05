package common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BrowserFactory extends Base {

    private static final String SET_BROWSER = "Chrome";
    private static final int WAIT = 3;
    private Properties prop = new Properties();
    private FileInputStream fis = new FileInputStream("C:\\Dev\\travel-automation\\src\\test\\java\\File.properties");

    BrowserFactory() throws FileNotFoundException {
    }

    void getBrowserDefault() throws IOException {
        prop.load(fis);
        if (prop.getProperty("DEFAULT_BROWSER").equals(SET_BROWSER)) {
            initializeChromeBrowser();
        } else
            initializeFirefoxBrowser();
    }

    private void initializeChromeBrowser() {
        System.setProperty(prop.getProperty("CHROME_PROPERTY"), prop.getProperty("CHROME_PATH"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("URL"));
    }

    private void initializeFirefoxBrowser() {
        System.setProperty(prop.getProperty("GECKO_PROPERTY"), prop.getProperty("GECKO_PATH"));
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("URL"));
    }

}
