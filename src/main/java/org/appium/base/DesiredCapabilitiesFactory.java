package org.appium.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.appium.utils.CapabilityFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import static org.appium.utils.CommonConst.*;

public class DesiredCapabilitiesFactory {

    private static AppiumDriver androidDriver;
    public static AppiumDriver setDesiredCapabilities(String app) throws IOException {
        DesiredCapabilities caps = CapabilityFactory.getDesiredCapabilities(app, "./src/main/resources/Capabilities.json");

//        switch (app) {
//            case "androidnative":
//                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
//                caps.setCapability("appPackage", "com.android.calculator2");
//                caps.setCapability("appActivity", ".Calculator");
//                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "demoApp");
//                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
//                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//                break;
//            case "iosnative":
//                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
//                caps.setCapability("appPackage", "com.android.calculator2");
//                caps.setCapability("appActivity", ".Calculator");
//                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "demoApp");
//                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
//                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//                break;
//            case "androidhybrid":
//                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
//                caps.setCapability(MobileCapabilityType.APP, "apkLib/selendroid-test-app-0.17.0.apk");
//                caps.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
//
//                caps.acceptInsecureCerts();
//                //                caps.setCapability("appPackage", "io.appium.android.apis");
////                caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
////                caps.setCapability("avdReadyTimeout","100000");
////                caps.setCapability("avdLaunchTimeout","230000");
////                caps.setCapability("appWaitPackage","io.appium.android.apis");
////                caps.setCapability("appWaitActivity","io.appium.android.apis.ApiDemos");
//
//                break;
//            case "ioshybrid":
//                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
//                caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apkLib/ApiDemos-debug.apk");
//                caps.setCapability("autoLaunch", "false");
//                caps.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
//                caps.setCapability(MobileCapabilityType.NO_RESET, "true");
//                caps.setCapability("unicodeKeyboard", "true");
//                caps.setCapability("resetKeyboard", "true");
//                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//                // Android Capabilities
//                caps.setCapability("appPackage", "io.appium.android.apis");
//                caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
//                break;
//            case "androidweb":
//                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
//                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Huawei P30");
//                caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//                caps.setCapability("chromedriverExecutable", "C:\\ChromeDriverExecutatble\\chromedriver.exe");
//                // caps.setCapability(MobileCapabilityType.AUTO_WEBVIEW, "true");
//                // caps.setCapability("autoWebviewTimeout", "true");
//
//                break;
//            case "iosweb":
//                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.2");
//                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
//                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITEST");
//                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
//                caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
//                caps.setCapability(MobileCapabilityType.AUTO_WEBVIEW, "true");
//                caps.setCapability("autoWebviewTimeout", "false");
//                break;
//            default:
//                System.out.println("Invalid Platform");
//        }
//
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, String.valueOf(WAITTIME));

        checkBrokenLink(APPIUMSERVER);

        androidDriver = new AndroidDriver(new URL(APPIUMSERVER), caps);

        return androidDriver;
    }

    static void checkBrokenLink(String linkUrl) throws IOException {
        if (isUrlValid(linkUrl)) {
            URL url = new URL(linkUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            if (conn.getResponseCode() > 400) {
                System.out.println((linkUrl) + " ===> status code is: " + conn.getResponseCode() + " is broken");
            }
        }

    }

    static boolean isUrlValid(String url) {
        try {
            URL url1 = new URL(url);
            url1.toURI();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}