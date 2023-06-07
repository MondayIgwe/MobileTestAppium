package org.page.interaction;

import io.appium.java_client.AppiumDriver;
import org.helper.SeleniumActions;
import static org.page.locator.AccessabilityElements.*;
import static org.utils.CommonConst.sleep;
import static org.utils.CommonConst.waitTime;

public class AccessabilityProcess {
    /*
     Separate the properties element from the functionality
     HOW (implementation)
     */

    SeleniumActions seleniumActions;

    public AccessabilityProcess(AppiumDriver appiumDriver) {
        seleniumActions = new SeleniumActions(appiumDriver);
        sleep(2000);
        seleniumActions.clickElement(accessibilityTab);
    }

    // Actions that perform or acts on the input
    public void customView() {
        seleniumActions.clickElement(customView);
    }

    public void accessibilityService() {
        seleniumActions.clickElement(accessibilityService);
    }
    public void accessibilityNodeQuerying() {
        seleniumActions.clickElement(accessibilityNodeQuerying);
    }



}

