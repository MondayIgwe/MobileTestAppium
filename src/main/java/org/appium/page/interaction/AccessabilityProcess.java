package org.appium.page.interaction;

import io.appium.java_client.AppiumDriver;
import org.appium.helper.SeleniumActions;
import org.appium.page.locator.AccessabilityElements;

import static org.appium.utils.CommonConst.sleep;

public class AccessabilityProcess {
    /*
     Separate the properties element from the functionality
     HOW (implementation)
     */

    SeleniumActions seleniumActions;

    public AccessabilityProcess(AppiumDriver appiumDriver) {
        seleniumActions = new SeleniumActions(appiumDriver);
        sleep(2000);
        seleniumActions.clickElement(AccessabilityElements.accessibilityTab);
    }

    // Actions that perform or acts on the input
    public void customView() {
        seleniumActions.clickElement(AccessabilityElements.customView);
    }

    public void accessibilityService() {
        seleniumActions.clickElement(AccessabilityElements.accessibilityService);
    }
    public void accessibilityNodeQuerying() {
        seleniumActions.clickElement(AccessabilityElements.accessibilityNodeQuerying);
    }



}

