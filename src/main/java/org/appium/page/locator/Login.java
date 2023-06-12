package org.appium.page.locator;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    public Login(AppiumDriver driver) {
        //PageFactory.initElements(driver, this);
    }

    public static By user = By.id("username");
    public static By pass = By.id("password");
    public static By submit = By.xpath("//button[contains(@type,'submit')]");
    //@FindBy(id="username") public static  WebElement username;
    //@FindBy(id="password") public static  WebElement password;
}
