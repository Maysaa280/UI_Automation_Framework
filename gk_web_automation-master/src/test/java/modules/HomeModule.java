package modules;

import org.testng.Assert;
import pages.HomePage;

public class HomeModule {

    private HomePage homePage;

    public HomeModule(HomePage homePage) {
        this.homePage = homePage;
    }

    public void validateHomePageFields() {
        boolean isHomepage = homePage.isHomePageFields();

        Assert.assertTrue(isHomepage, "Failed to validate that home page loaded successfully.");
    }
}
