package TestAnyThing;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.appium.helper.SeleniumActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryModel {
    AndroidDriver driver;
    @FindBy(how = How.CLASS_NAME, using = "q") WebElement name;
    public PageFactoryModel(AppiumDriver driver){
        PageFactory.initElements(driver, this);
        SeleniumActions seleniumActions = new SeleniumActions(driver);
        //seleniumActions.clickElement(name);
    }





}
