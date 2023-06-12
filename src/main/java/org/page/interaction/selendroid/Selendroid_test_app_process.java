package org.page.interaction.selendroid;

import io.appium.java_client.AppiumDriver;
import org.helper.SeleniumActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.page.locator.selendroidLocators.Selendroid_test_app.*;
import static org.utils.CommonConst.sleep;

public class Selendroid_test_app_process {

    AppiumDriver appiumDriver;
    static SeleniumActions seleniumActions;
    public Selendroid_test_app_process(AppiumDriver appiumDriver_){
        appiumDriver = appiumDriver_;
        seleniumActions = new SeleniumActions(appiumDriver);
    }

    public void selendroidProcess(){
        sleep(5000);
        seleniumActions.clickElement(chromeBtn);
     //   seleniumActions.switchToWebView();
        new WebDriverWait(appiumDriver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(gotoHomeBtn));
       // seleniumActions.clearField(nameInput);
       // seleniumActions.sendKeyz(nameInput, "test james");
     //   seleniumActions.switchToWebView();
        seleniumActions.clickElement(gotoHomeBtn);
    }
}
