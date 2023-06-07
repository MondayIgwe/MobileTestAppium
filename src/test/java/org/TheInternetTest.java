package org;

import org.page.interaction.TheInternetHerokuAppProcess;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

// PRESENTATION OR TESTCASE LAYER
public class TheInternetTest extends LifeCycle {
    static TheInternetHerokuAppProcess theInternetHerokuAppProcess;

    @Test
    public void internetTest() {
        try {
            theInternetHerokuAppProcess = new TheInternetHerokuAppProcess(androidDriver_);
            assertNotNull(theInternetHerokuAppProcess);
            assertNotNull(androidDriver_);

            theInternetHerokuAppProcess.chooselink("A/B Testing");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
