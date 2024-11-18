package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.CookieManager;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class BaseTests {
    protected HomePage homePage;
    private EventFiringWebDriver driver;
    private TakesScreenshot camera;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        //driver = new EventFiringWebDriver(new FirefoxDriver());
        driver.register(new EventReporter());
        //driver = new FirefoxDriver();
        //driver.get("https://the-internet.herokuapp.com/");
        //homePage = new HomePage(driver);
    }

    @AfterClass()
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void getUrl() {
        driver.get("https://the-internet.herokuapp.com");
        homePage = new HomePage(driver);
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            camera = driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private ChromeOptions getChromeOptions(){
        ChromeOptions options= new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        //options.setHeadless(true);
        return options;
    }
    public CookieManager getCookieManager(){
        return new CookieManager(driver);
    }


}
