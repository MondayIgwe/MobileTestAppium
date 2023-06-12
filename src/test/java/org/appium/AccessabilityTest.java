package org.appium;

import org.baseTest.LifeCycle;
import org.appium.enumConstant.Apps;
import org.appium.page.interaction.AccessabilityProcess;
import org.testng.annotations.*;

import java.io.IOException;
import static org.appium.services.AppiumServer.stopServer;
import static org.testng.Assert.assertNotNull;
import static org.appium.utils.CommonConst.sleep;
import static org.appium.utils.EmulatorProcess.*;
import static org.appium.utils.EmulatorProcess.processes;

public class AccessabilityTest extends LifeCycle {
    static AccessabilityProcess accessability;
    @BeforeMethod
    public void setUp() {
        try {
            Apps[] apps = {Apps.APIDEMOAPP};
            androidDriver = createAndroidDriver(apps);
            assertNotNull(androidDriver);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void RunTest() {
        accessability = new AccessabilityProcess(androidDriver);
        assertNotNull(accessability);
        accessability.customView();

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
