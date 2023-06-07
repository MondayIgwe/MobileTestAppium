package org.page.locator;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class AccessabilityElements {
    /*
     SOLID principles
     Separate the properties element from the functionality
     WHAT(describe what the user wants to do)

     */


    public static By accessibilityTab = AppiumBy.ById.accessibilityId("Accessibility");
    public static By accessibilityService = AppiumBy.ById.accessibilityId("Accessibility Service");
    public static By accessibilityNodeQuerying = AppiumBy.ById.accessibilityId("Accessibility Node Querying");
    public static By customView = AppiumBy.ById.accessibilityId("Custom View");

    public static By submit = AppiumBy.ByAndroidUIAutomator.androidUIAutomator("new UISelctor().resourId('')");


}

