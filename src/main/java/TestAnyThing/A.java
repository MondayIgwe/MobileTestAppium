//package TestAnyThing;
//
//import static io.appium.java_client.MobileBy.AccessibilityId;
//
//import io.appium.java_client.AppiumBy;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileBy;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.ios.IOSDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.page.locator.App;
//
//import java.time.Duration;
//
//public class A {
//
//    public AppiumDriver appiumDriver;
//    public AndroidDriver androidDriver;
//    public IOSDriver iosDriver;
//
//    public A(AppiumDriver appiumDriver, AndroidDriver androidDriver, IOSDriver iosDriver) {
//        this.androidDriver = androidDriver;
//        this.appiumDriver = appiumDriver;
//        this.iosDriver = iosDriver;
//
//    }
//
//
//    public void findById(String id) {
//        AppiumBy ele = (AppiumBy) appiumDriver.findElement(AppiumBy.accessibilityId(id)));
//        androidDriver.findElement(AppiumBy.ByAccessibilityId.accessibilityId(id));
//        iosDriver.findElement(AppiumBy.ByClassName.id(id));
//
//    }
//
//    public static boolean waitForPresence(AppiumDriver driver, Duration timeLimitInSeconds, String targetResourceId) {
//        boolean isElementPresent = false;
//        try {
//          // AppiumBy ele =  (AppiumBy) driver.findElement(AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"" + targetResourceId + "\")");
//            WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
//            wait.until(ExpectedConditions.visibilityOf(mobileElement));
//            isElementPresent = mobileElement.isDisplayed();
//            return isElementPresent;
//        } catch (Exception e) {
//            isElementPresent = false;
//            System.out.println(e.getMessage());
//            return isElementPresent;
//        }
//    }
//
//    public void clickAction() {
//
//    }
//}
