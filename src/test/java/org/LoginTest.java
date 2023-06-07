package org;

import org.page.interaction.LoginProcess;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

public class LoginTest extends LifeCycle {

    static LoginProcess loginProcess;

    @Test
    public void verifyLogin() {
        loginProcess = new LoginProcess(androidDriver_);
        assertNotNull(loginProcess);
        assertNotNull(androidDriver_);
        loginProcess.LoginDetails();
    }
}
