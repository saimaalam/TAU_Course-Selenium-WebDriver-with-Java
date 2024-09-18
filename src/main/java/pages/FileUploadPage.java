package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class FileUploadPage {
    private WebDriver driver;
    private By inputField= By.id("file-upload");
    private By upLoadButton= By.id("file-submit");
    private By uploadedFile = By.id("uploaded-files");
    public FileUploadPage(WebDriver driver){

        this.driver=driver;
    }
    public void clickUploadButton(){
        driver.findElement(upLoadButton).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    /**
     * provides path of the file to the form then clicks Upload button
     * @param absolutePathofFile The complete path of the file upload
     */
    public void uploadFile(String absolutePathofFile){
        driver.findElement(inputField).sendKeys(absolutePathofFile);
        clickUploadButton();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public String getuploadedFile(){
        return driver.findElement(uploadedFile).getText();
    }
}
