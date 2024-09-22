package cookies;

import base.BaseTests;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class CookiesTests extends BaseTests {
    @Test
    public void testDeleteCookie(){
        var cookieManager = getCookieManager();
        Cookie cookie = cookieManager.buildCookie("ockets", "%7B%22298349752%22%3A%22298291000%22%7D");
        var cookies = cookieManager.getCookie("optimizelyBuckets");
        cookieManager.deleteCookie(cookies);
        assertFalse(cookieManager.isCookiePresent(cookies), "Cookie was not deleted");
    }

}
