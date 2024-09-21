package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver.get("https://the-internet.herokuapp.com/");
        //homePage = new HomePage(driver);
    }
    @AfterClass()
    public void tearDown(){
        driver.quit();
    }
    @BeforeMethod
    public void getUrl() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

}
