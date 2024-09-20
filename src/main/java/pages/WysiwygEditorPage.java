package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    private WebDriver driver;
    private By closeNotificationButton= By.xpath("//div[@class='tox-notifications-container']//button");
    private String editorIframeId= "mce_0_ifr";
    private By textArea= By.id("tinymce");
    private By decreaseIndentButton = By.xpath("button[title='Increase indent']");

    public WysiwygEditorPage(WebDriver driver){

        this.driver=driver;
    }
    public void closeToxNotification(){
        driver.findElement(closeNotificationButton).click();
    }
    /*
     Edit area is inside an iframe. switching to the iframe
     */
    public void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }
    //exiting from iframe
    public void switchToMainArea(){
        driver.switchTo().parentFrame();
    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }
    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    public String getTextFromEditor(){
        switchToEditArea();
        String text= driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }
    public void decreaseIndention(){
        driver.findElement(decreaseIndentButton).click();
    }
}
