package org.page.interaction;

import io.appium.java_client.AppiumDriver;
import org.helper.SeleniumActions;
import static org.page.locator.AccessabilityElements.*;

public class AccessabilityProcess {
    /*
     Separate the properties element from the functionality
     HOW (implementation)
     */

    SeleniumActions seleniumActions;

    public AccessabilityProcess(AppiumDriver appiumDriver) {
        seleniumActions = new SeleniumActions(appiumDriver);
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

