package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowManager {
    private final WebDriver driver;
    private final WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void refreshPage() {
        navigate.refresh();
    }

    public void goToUrl(String url) {
        navigate.to(url);
    }

    public void switchToTab(String tabTitle) {
        Set<String> windows = driver.getWindowHandles();
        System.out.println("Number of tabs: " + windows.size());
        System.out.println("Window handles: ");
        windows.forEach(element -> System.out.println(element));
        for (String window : windows) {
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);
            System.out.println("Current Window Title: " + driver.getTitle());
            if (tabTitle.equals(driver.getTitle())) {
                break;
            }
        }
    }


}
