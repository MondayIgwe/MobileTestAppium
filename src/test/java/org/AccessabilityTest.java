package org;

import org.page.interaction.AccessabilityProcess;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

public class AccessabilityTest extends LifeCycle {
    static AccessabilityProcess accessability;

    @Test
    public void RunTest() {
        accessability = new AccessabilityProcess(androidDriver_);
        assertNotNull(accessability);
        accessability.customView();

    }

}
