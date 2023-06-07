package TestAnyThing;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageObjectModel {

    AndroidDriver driver;

    public PageObjectModel(AndroidDriver driver) {
        this.driver = driver;

        /////////////////////
        WebElement element = driver.findElement(By.id(driver.toString()));
    }


}
