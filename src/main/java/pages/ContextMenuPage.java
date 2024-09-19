package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private WebDriver driver;
    private By boxArea= By.id("hot-spot");
    public ContextMenuPage(WebDriver driver){
        this.driver=driver;
    }
    public void rightClickOnBox(){
        Actions action= new Actions(driver);
        action.contextClick(driver.findElement(boxArea)).perform();

    }
    public void clickOK(){
         driver.switchTo().alert().accept();
    }
    public String getPopupText(){
        return driver.switchTo().alert().getText();
    }
}
