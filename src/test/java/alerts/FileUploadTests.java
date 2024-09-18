package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        FileUploadPage fileUploadPage= homePage.clickFileUpload();
        fileUploadPage.uploadFile("E:/selenium/webdriver_java/resources");
        assertEquals(fileUploadPage.getuploadedFile(),"chromedriver.exe","Uploaded file is not correct file");
    }
}
