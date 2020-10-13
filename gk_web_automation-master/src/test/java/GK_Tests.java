import modules.HomeModule;
import modules.WomenModule;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.WomenPage;
import utils.DataProviderObject;
import utils.DriverFactory;
import utils.GLOBAL_VARIABLES;

public class GK_Tests {

    @Test(groups = "landingPage", dataProvider = "headers", dataProviderClass = DataProviderObject.class)
    public void landingPages(String testNo, String browser) throws Exception {
        WebDriver driver = DriverFactory.getInstance().getBrowserInstance(browser);
        driver.get(GLOBAL_VARIABLES.ECOMERCE_URL);

        HomeModule homeModule = new HomeModule(new HomePage(driver));
        homeModule.validateHomePageFields();
    }

    @Test(groups = "womenColor", dataProvider = "filterColor", dataProviderClass = DataProviderObject.class)
    public void womenColorSort(String testNo, String browser, String header, String color) throws Exception {
        WebDriver driver = DriverFactory.getInstance().getBrowserInstance(browser);
        driver.get(GLOBAL_VARIABLES.ECOMERCE_URL);

        WomenModule womenModule = new WomenModule(new WomenPage(driver));
        womenModule.verifyCategoryHeader(header);
        womenModule.verifyColor(color);
    }

    @AfterMethod(alwaysRun = true)
    public void destroyDriver() {
        if(DriverFactory.getInstance().getDriver() != null) {
            DriverFactory.getInstance().quitDriver();
        }
    }
}
