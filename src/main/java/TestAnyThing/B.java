//package TestAnyThing;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class B {
//
//    private static MobileElement mobileElement;
//
//    public static boolean waitForPresence(AppiumDriver driver, Duration timeLimitInSeconds, String targetResourceId) {
//        boolean isElementPresent = false;
//        try {
//            // AppiumBy ele =  (AppiumBy) driver.findElement(AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"" + targetResourceId + "\")");
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
//}