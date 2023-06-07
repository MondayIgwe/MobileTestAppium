package org.page.interaction;

import io.appium.java_client.AppiumDriver;
import org.helper.SeleniumActions;
import org.openqa.selenium.Keys;
import org.page.locator.Login;
import java.io.IOException;
import static org.page.locator.Login.*;
import static org.utils.CommonConst.sleep;
import static org.utils.PropertiesProcess.*;

public class LoginProcess {

    Login login;
    SeleniumActions seleniumActions;

    public LoginProcess(AppiumDriver driver) {
       // login = new Login(driver);
        seleniumActions = new SeleniumActions(driver);
        try {
            getProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void LoginDetails() {
        seleniumActions.sendKeyz(user, username + Keys.TAB);
        seleniumActions.sendKeyz(pass, password);
        sleep(2000);
        seleniumActions.clickElement(submit);
        seleniumActions.explicitWaitUrl("secure");
    }
}
