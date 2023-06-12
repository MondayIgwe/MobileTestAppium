package org.appium;

import org.baseTest.LifeCycle;
import org.appium.enumConstant.Apps;
import org.appium.page.interaction.selendroid.Selendroid_test_app_process;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.appium.services.AppiumServer.stopServer;
import static org.testng.Assert.assertNotNull;
import static org.appium.utils.CommonConst.sleep;
import static org.appium.utils.EmulatorProcess.*;

public class SelendroidTest extends LifeCycle {
    //static Selendroid_test_app_process selendroid_test_app_process;

    @BeforeMethod
    public void setUp() {
        try {
            Apps[] apps = {Apps.SELENDROIDAPP};
            androidDriver = createAndroidDriver(apps);
            assertNotNull(androidDriver);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void RunSelendroidTest() {
        Selendroid_test_app_process selendroid_test_app_process = new Selendroid_test_app_process(androidDriver);
        assertNotNull(selendroid_test_app_process);
        selendroid_test_app_process.selendroidProcess();
        System.out.println("Selendroid Test");


    }

    @AfterMethod
    public void tearDown() throws IOException {
        if (androidDriver != null)
            androidDriver.quit();

        // Stop the appium server
        stopServer();

        // kill all process and emulator avd device
        for (int i = 0; i < processes.length; i++) {
            sleep(2000);
            if (isProcessRunning(processes[i]))
                KillProcess(processes[i]);
        }
    }
}
