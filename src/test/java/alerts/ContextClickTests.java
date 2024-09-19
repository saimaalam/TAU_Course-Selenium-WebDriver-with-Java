package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

import static org.testng.Assert.assertEquals;

public class ContextClickTests extends BaseTests {
    @Test
    public void testRightClick(){
        ContextMenuPage contextMenuPage= homePage.clickContextMenu();
        contextMenuPage.rightClickOnBox();
        assertEquals(contextMenuPage.getPopupText(),"You selected a context menu","Popup message incorrect");
        contextMenuPage.clickOK();
    }
}
