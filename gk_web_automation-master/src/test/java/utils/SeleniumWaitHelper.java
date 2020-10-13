package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumWaitHelper {
    private static int seconds = 30;
    private WebDriver driver;

    public SeleniumWaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementVisibility(By locator) {
        try {
            WebDriverWait driverWait = new WebDriverWait(driver, seconds);

            return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    public List waitForAllElementVisibility(By locator) {
        try {
            WebDriverWait driverWait = new WebDriverWait(driver, seconds);

            return driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    public WebElement waitForElementCickability(By locator) {
        try {
            WebDriverWait driverWait = new WebDriverWait(driver, seconds);

            return driverWait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    public Boolean waitForElementInvisibility(By locator) {
        try {
            WebDriverWait driverWait = new WebDriverWait(driver, seconds);

            return driverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (NoSuchElementException e) {
            throw e;
        }
    }
}
