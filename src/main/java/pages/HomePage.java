package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver= driver;
    }
    private void clickLink(String linkText){

        driver.findElement(By.linkText(linkText)).click();
    }
    public LoginPage clickFormAuthencation(){
        clickLink("Form Authentication");
        return new LoginPage(driver);

    }
    public DropdownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }
    public ForgotPasswordPage clickForgotPassword(){
        clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }
    public  HoversPage clickHovers(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }
    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }
    public HorizontalSliderPage clickHorizontalSlider(){
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }
    public AlertsPage clickAJavaScriptAlerts(){
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }
    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return new FileUploadPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }
    public ContextMenuPage clickContextMenu(){
        clickLink("Context Menu");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        return new ContextMenuPage(driver);
    }
    public WysiwygEditorPage clickWysiwygEditor(){
        clickLink("WYSIWYG Editor");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        return new WysiwygEditorPage(driver);
    }

    public FramesPage clickFramesPage(){
        clickLink("Frames");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        return new FramesPage(driver);
    }
    public LargeAndDeepDomPage clickLargeAndDeepDom(){
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }
    public InfiniteScrollPage clickInfiniteScroll(){
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

}
