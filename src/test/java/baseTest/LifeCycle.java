package baseTest;

import io.appium.java_client.AppiumDriver;
import org.base.Web;
import org.enumConstant.Apps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.base.DesiredCapabilitiesFactory.setDesiredCapabilities;
import static org.services.AppiumServer.startServer;
import static org.utils.CommonConst.*;

public class LifeCycle {
    public static Web web;
    public static AppiumDriver androidDriver;
    private static final ThreadLocal<AppiumDriver> DRIVER = new ThreadLocal<>();
    private static final Logger LOG = LogManager.getLogManager().getLogger("LifeCycle.class");

    public static AppiumDriver createAndroidDriver(Apps[] apps) throws IOException {

        sleep(waitTime);

        startServer(); // Start Appium Server

        return pickDeviceType(apps);
    }

    private static AppiumDriver pickDeviceType(Apps[] apps) throws IOException {

        for (int i = 0; i < apps.length; i++) {
            Apps appType = apps[i];
            String app = appType.toString().toLowerCase();

            if (app.equals(THEINTERNETWEBAPP)) {
                System.out.println("======= EXECUTING ON: " + REALDEVICE + "===============");
                androidDriver = setDesiredCapabilities(app);

                if (app.contains("login")) {
                    web = new Web(androidDriver, INTERNETHEROKUAPP + "login");
                } else {
                    web = new Web(androidDriver, INTERNETHEROKUAPP);
                }

                return androidDriver;
            } else if (app.equals(APIDEMOAPP) || app.equals(SELENDROIDAPP)) {
                // StartEmulator(); // Start emulator or simulator
                androidDriver = setDesiredCapabilities(app);
                return androidDriver;
            } else {
                System.out.println("==========App not found==========");
            }
        }
        return null;
    }

    public static <D extends AppiumDriver> D getDriver() {
        return (D) LifeCycle.DRIVER.get();
    }

    public static <D extends AppiumDriver> void setDriver(final D driver) {
        LifeCycle.DRIVER.set(driver);
    }

    private static void setUpDriverTimeouts() {
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
