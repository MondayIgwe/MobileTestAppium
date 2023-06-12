package org.appium.page.interaction;

import io.appium.java_client.AppiumDriver;
import org.appium.helper.SeleniumActions;
import org.appium.page.locator.Login;
import org.openqa.selenium.Keys;

import java.io.IOException;

import static org.appium.utils.CommonConst.sleep;
import static org.appium.utils.PropertiesProcess.*;

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
        seleniumActions.sendKeyz(Login.user, username + Keys.TAB);
        seleniumActions.sendKeyz(Login.pass, password);
        sleep(2000);
        seleniumActions.clickElement(Login.submit);
        seleniumActions.explicitWaitUrl("secure");
    }
}
