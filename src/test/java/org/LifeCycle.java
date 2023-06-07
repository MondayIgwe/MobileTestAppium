package org;

;
import io.appium.java_client.AppiumDriver;
import org.base.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.page.interaction.AccessabilityProcess;
import org.testng.annotations.*;

import java.io.IOException;

import static org.base.DriverManager.*;
import static org.services.AppiumServer.stopServer;
import static org.testng.Assert.assertNotNull;
import static org.utils.CommonConst.REALDEVICE;
import static org.utils.CommonConst.sleep;
import static org.utils.EmulatorProcess.*;
import static org.utils.EmulatorProcess.processes;


public class LifeCycle {

    public static AppiumDriver androidDriver_;
    // SDLC
    @BeforeTest
    public void setUp() {
        try {
            androidDriver_ = createAndroidDriver(REALDEVICE);
            assertNotNull(androidDriver_);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @AfterTest
    public void tearDown() throws IOException {
        androidDriver_.quit();

        // Stop the appium server
        stopServer();

        sleep(2000);

        // kill all process and emulator avd device
        for (int i = 0; i < processes.length; i++) {
            if (isProcessRunning(processes[i]))
                KillProcess(processes[i]);
        }


    }
}
