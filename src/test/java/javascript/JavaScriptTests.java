package javascript;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LargeAndDeepDomPage;

public class JavaScriptTests extends BaseTests {
    @Test
    public void testScrollToTable(){
        LargeAndDeepDomPage largeAndDeepDomPage=homePage.clickLargeAndDeepDom();
        largeAndDeepDomPage.scrollTotable();
    }
    @Test
    public void testScrollToFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);

    }
}
