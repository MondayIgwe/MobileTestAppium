package org.appium.page.interaction;

import io.appium.java_client.AppiumDriver;
import org.appium.helper.SeleniumActions;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.appium.page.locator.TheInternetHerokuApp.homePage;

public class TheInternetHerokuAppProcess {
    SeleniumActions seleniumActions;
    public TheInternetHerokuAppProcess(AppiumDriver appiumDriver) {
        seleniumActions = new SeleniumActions(appiumDriver);
    }

    public void chooselink(String linkText) throws InterruptedException {
        List<WebElement> elements = seleniumActions.findAll(homePage);
        for (WebElement ele : elements) {
            if (ele.getText().equals(linkText)){
                Thread.sleep(2000);
                ele.click();
            }

            break;
        }
    }
}
