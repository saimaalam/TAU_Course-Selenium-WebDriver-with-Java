package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropdownPage;
import java.util.List;
import static org.testng.Assert.*;

public class DropdownTests extends BaseTests {
    @Test
    public void testSelectOptions(){
        DropdownPage dropDownPage = homePage.clickDropDown();
        String option= "Option 1";
        dropDownPage.selectFromDropdown(option);
        List<String>selectedOptions= dropDownPage.getSelectedOption();
        assertEquals(selectedOptions.size(),1,"Incorrect number of selections");
        assertTrue(selectedOptions.contains(option),"Options not selected ");
    }

}
