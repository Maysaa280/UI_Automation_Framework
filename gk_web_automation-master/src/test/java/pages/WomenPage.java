package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ReadPageElementsFile;
import utils.SeleniumWaitHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class WomenPage {

    private WebDriver driver;
    private ReadPageElementsFile propertiesFile = new ReadPageElementsFile();
    private Properties prop = propertiesFile.getElementProperties();
    private SeleniumWaitHelper seleniumWaitHelper;

    By womenMenu = By.xpath(prop.getProperty("womenMenu"));
    By categoryHeader = By.cssSelector(prop.getProperty("categoryHeader"));
    By ajaxLoader = By.xpath(prop.getProperty("ajaxLoader"));
    By imageContainer = By.cssSelector(prop.getProperty("imageContainer"));
    By productPopup = By.xpath(prop.getProperty("productPopup"));
    By closeProductPopup = By.xpath(prop.getProperty("closeProductPopup"));
    By productColorList = By.xpath(prop.getProperty("productColorList"));
    By productIframe = By.xpath(prop.getProperty("productIframe"));

    public WomenPage(WebDriver driver) throws IOException {
        this.driver = driver;
        seleniumWaitHelper = new SeleniumWaitHelper(this.driver);
    }

    public String getCategoryHeader() {
        try {
            WebElement womenMenuElem = seleniumWaitHelper.waitForElementVisibility(womenMenu);
            womenMenuElem.click();

            WebElement categotyHeaderElem = seleniumWaitHelper.waitForElementVisibility(categoryHeader);

            return categotyHeaderElem.getText().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean chooseColor(String color) {
        try {
            WebElement colorElem = seleniumWaitHelper.waitForElementCickability(By.xpath("//form[@id='layered_form']//a[text()='" + color + "']/../../input[@type != 'hidden']"));
            colorElem.click();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int colorResultsSize(String color) {
        seleniumWaitHelper.waitForElementInvisibility(ajaxLoader);

        List<WebElement> results = seleniumWaitHelper.waitForAllElementVisibility(imageContainer);

        return results.size();
    }

    public boolean colorResults(String color) {
        try {
            List<WebElement> results = seleniumWaitHelper.waitForAllElementVisibility(imageContainer);
            List<String> strColors = new ArrayList<>();
            List<WebElement> colorListElems;
            WebElement iframe;

            for(WebElement result : results) {
                result.click();

                seleniumWaitHelper.waitForElementVisibility(productPopup);

                iframe = seleniumWaitHelper.waitForElementVisibility(productIframe);
                driver.switchTo().frame(iframe);

                colorListElems = seleniumWaitHelper.waitForAllElementVisibility(productColorList);

                for(WebElement colorElem : colorListElems) {
                    strColors.add(colorElem.getAttribute("title"));
                }
                driver.switchTo().defaultContent();

                WebElement btnClose = seleniumWaitHelper.waitForElementCickability(closeProductPopup);
                btnClose.click();

                Thread.sleep(1000);
            }

            if(strColors.contains(color)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
