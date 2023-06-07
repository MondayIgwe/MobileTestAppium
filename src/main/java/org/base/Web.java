package org.base;

import io.appium.java_client.AppiumDriver;
import org.helper.SeleniumActions;

public class Web {
    AppiumDriver driver;

    public Web(AppiumDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        new SeleniumActions(driver).waitForLoad();
    }

}
