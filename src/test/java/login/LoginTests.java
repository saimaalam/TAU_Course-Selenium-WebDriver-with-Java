package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;


public class LoginTests extends BaseTests {
    @Test(priority = 1)
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickFormAuthencation();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage= loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"),
                "Alert Text is incorrect");
    }
    @Test(priority = 2)
    public void testWrongUsername(){
        LoginPage loginPage = homePage.clickFormAuthencation();
        loginPage.setUsername("tom");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getAlart().contains("Your username is invalid!"),"Alert Test is incorrect");
    }
    @Test(priority = 3)
    public void testWrongPassword(){
        LoginPage loginPage = homePage.clickFormAuthencation();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecret");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getAlart().contains("Your password is invalid!"),
                "Alert Test is incorrect");
    }
    @Test(priority = 4)
    public void testBlankUsername(){
        LoginPage loginPage = homePage.clickFormAuthencation();
        loginPage.setUsername("");
        loginPage.setPassword("SuperSecret");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getAlart().contains("Your username is invalid!"), "Alert Test is incorrect");


    }
}
