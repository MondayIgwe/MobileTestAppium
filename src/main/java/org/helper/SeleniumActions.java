package org.helper;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumActions {

    AppiumDriver driver;

    public SeleniumActions(AppiumDriver driver_) {
        driver = driver_;
    }


    public WebElement findOne(By by) {
        WebElement element = driver.findElement(by);
        return explicitWaitOnly(element);
    }

    public void sendKeyz(By element, String text) {
        WebElement ele = findOne(element);
        ele.sendKeys(text);
    }

    public WebElement findAllPickOne(By by, WebElement elementToSearchForIntheCollection) {

        List<WebElement> elements = driver.findElements(by);
//        return elements.forEach((n) -> {
//            n.getText().equals(element.getText());
//        });
        for (WebElement ele : elements) {
            if (ele.equals(elementToSearchForIntheCollection))
                return ele;
        }
        return null;
    }

    public List<WebElement> findAll(By by) {
        return driver.findElements(by);
    }

    public void clickElement(By by) {
        explicitWait(by).click();
    }


    public WebElement explicitWait(By by) {
        try {
            WebElement element = findOne(by);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (WebDriverException driverException) {
            System.out.println(driverException.getMessage());
        }

        return null;
    }

    public Boolean explicitWaitUrl(String subUrl) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
            return wait.until(ExpectedConditions.urlContains(subUrl));
        } catch (WebDriverException driverException) {
            System.out.println(driverException.getMessage());
        }

        return false;
    }

    public WebElement explicitWaitOnly(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (WebDriverException driverException) {
            System.out.println(driverException.getMessage());
        }

        return null;
    }

    public WebElement explicitWaitOnly(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
            return wait.until(ExpectedConditions.presenceOfElementLocated(element));
        } catch (WebDriverException driverException) {
            System.out.println(driverException.getMessage());
        }

        return null;
    }

    public List<WebElement> explicitWaitForAll(By by, WebElement elementToSearchForIntheCollection) {
        try {
            List<WebElement> eles = findAll(by);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfAllElements(eles));
        } catch (WebDriverException driverException) {
            System.out.println(driverException.getMessage());
        }

        return null;
    }

    public void waitForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(300)).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
