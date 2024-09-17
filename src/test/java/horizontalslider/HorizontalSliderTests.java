package horizontalslider;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {
    @Test
    public void testSlider(){
        String value = "4";
        HorizontalSliderPage horizontalSliderPage= homePage.clickHorizontalSliderPage();
       horizontalSliderPage.setSliderValue(value);
        assertEquals(horizontalSliderPage.getSliderValue(), value, "Slider value is incorrect");
        //comment
    }

}
