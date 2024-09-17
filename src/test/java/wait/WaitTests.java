package wait;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WaitTests extends BaseTests {
    @Test
    public void testWaitUntillHidden() {
        var loadingPage = homePage.clickADynamicLoading().clickExample1();
        loadingPage.clickStartButton();
        assertEquals(loadingPage.getLoadedText(),"Hello World!","Loaded text incorrect");
        loadingPage.waitimplicitly(30);
    }
}

