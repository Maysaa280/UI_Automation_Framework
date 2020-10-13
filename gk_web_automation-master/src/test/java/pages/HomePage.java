package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ReadPageElementsFile;
import utils.SeleniumWaitHelper;

import java.io.IOException;
import java.util.Properties;

public class HomePage {

    private WebDriver driver;
    private ReadPageElementsFile propertiesFile = new ReadPageElementsFile();
    private Properties prop = propertiesFile.getElementProperties();
    private SeleniumWaitHelper seleniumWaitHelper;

    By womenMenu = By.xpath(prop.getProperty("womenMenu"));
    By searchField = By.id(prop.getProperty("searchField"));

    public HomePage(WebDriver driver) throws IOException {
        this.driver = driver;
        seleniumWaitHelper = new SeleniumWaitHelper(this.driver);
    }

    public boolean isHomePageFields() {
        try {
            // Verify visibility of these elements from the home page
            seleniumWaitHelper.waitForElementVisibility(womenMenu);
            seleniumWaitHelper.waitForElementVisibility(searchField);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
