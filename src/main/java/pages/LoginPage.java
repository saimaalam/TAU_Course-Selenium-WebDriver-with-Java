package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    private By usernameField= By.id("username");
    private By passwordield= By.id("password");
    private By loginButton=  By.cssSelector("#login button");
    private By statusalert= By.id("flash");
    public LoginPage(WebDriver driver){
        this.driver= driver;
    }
    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    public void setPassword(String password){
        driver.findElement(passwordield).sendKeys(password);
    }
    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }
    public String getAlart(){
        return driver.findElement(statusalert).getText();
    }
    public WebElement getUsernamefield(){
        return driver.findElement(usernameField);
    }

}
