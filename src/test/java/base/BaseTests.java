package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    private TakesScreenshot camera;

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
    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE==result.getStatus())
        {
            camera= (TakesScreenshot)driver;
            File screenshot=camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() +".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
