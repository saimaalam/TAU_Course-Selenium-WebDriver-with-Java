package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AlertsPage;
import static org.testng.Assert.*;

public class AlertTests extends BaseTests {
    @Test
    public void testAcceptAlert(){
        AlertsPage alertsPage = homePage.clickAJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),"You successfully clicked an alert");
    }
    @Test
    public void testGetTextFromAlert(){
        AlertsPage alertsPage = homePage.clickAJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text= alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text,"I am a JS Confirm","Alert text is not correct");
    }
    @Test
    public void testInputInAlert(){
        AlertsPage alertsPage = homePage.clickAJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text= "Test input in alert !!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),"You entered: "+text,"Result text is not correct");
    }
}
