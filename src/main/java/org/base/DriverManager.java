package org.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.enumConstant.Apps;

import static org.services.AppiumServer.startServer;
import static org.utils.CommonConst.*;
import static org.utils.EmulatorProcess.*;
import static org.base.DesiredCapabilitiesFactory.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DriverManager {
    public static Web web;
    private static final ThreadLocal<AppiumDriver> DRIVER = new ThreadLocal<>();
    private static final Logger LOG = LogManager.getLogManager().getLogger("DriverManager.class");

    public static AppiumDriver createAndroidDriver(String deviceType) throws IOException {

        if (deviceType.equals(REALDEVICE))
            System.out.println("=======EXECUTING ON: " + REALDEVICE + "===============");
        else
            StartEmulator(); // Start emulator or simulator

        sleep(3000);

        startServer(); // Start Appium Server

        // Select a platform and mobile app
        Apps[] apps = {Apps.ANDROIDNATIVE, Apps.IOSNATIVE, Apps.ANDROIDWEB, Apps.IOSWEB, Apps.ANDROIDHYBRID, Apps.IOSHYBRID};
        Apps appType = apps[2];
        String app = appType.toString().toLowerCase();

        AppiumDriver androidDriver = setDesiredCapabilities(app);

        if (app.equals(Apps.ANDROIDWEB.toString().toLowerCase())) {
            web = new Web(androidDriver, INTERNETHEROKUAPP + "login");
        }
        return androidDriver;
    }

    public static <D extends AppiumDriver> D getDriver() {
        return (D) DriverManager.DRIVER.get();
    }

    public static <D extends AppiumDriver> void setDriver(final D driver) {
        DriverManager.DRIVER.set(driver);
    }

    private static void setUpDriverTimeouts() {
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
