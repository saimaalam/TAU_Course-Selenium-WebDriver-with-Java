package hover;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HoversPage;
import static org.testng.Assert.*;

public class HoverTests extends BaseTests {
    @Test
    public void testHoverUser1(){
       HoversPage hoversPage= homePage.clickHovers();
       HoversPage.FigureCaption caption = hoversPage.hoverOverFigure(1);
       assertTrue(caption.isCaptionDisplayed(),"Caption is not displayed");
       assertEquals(caption.getTitle(),"name: user1","Caption title is incorrect");
       assertEquals(caption.getLinkText(),"View profile","Link text is incorrect");
       assertTrue(caption.getLink().endsWith("/users/1"),"Link is incorrect");
    }

    @Test
    public void testHoverUser2(){
        HoversPage hoversPage= homePage.clickHovers();
        HoversPage.FigureCaption caption = hoversPage.hoverOverFigure(2);
        assertTrue(caption.isCaptionDisplayed(),"Caption is not displayed");
        assertEquals(caption.getTitle(),"name: user2","Caption title is incorrect");
        assertEquals(caption.getLinkText(),"View profile","Link text is incorrect");
        assertTrue(caption.getLink().endsWith("/users/2"),"Link is incorrect");
    }
}
