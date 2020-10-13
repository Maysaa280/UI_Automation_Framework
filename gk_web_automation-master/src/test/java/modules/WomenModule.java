package modules;

import org.testng.Assert;
import pages.WomenPage;

public class WomenModule {

    private WomenPage womenPage;

    public WomenModule(WomenPage womenPage) {
        this.womenPage = womenPage;
    }

    public void verifyCategoryHeader(String expectedHeader) {
        String actualHeader = womenPage.getCategoryHeader();

        Assert.assertEquals(actualHeader, expectedHeader, "Failed to verify category header.");
    }

    public void verifyColor(String color) {
        boolean isColor = womenPage.chooseColor(color);

        Assert.assertTrue(isColor, "Failed to click color: " + color);

        int colorSize = womenPage.colorResultsSize(color);

        for(int i = 0; i < colorSize; i++) {
            boolean isResults = womenPage.colorResults(color);
            Assert.assertTrue(isResults, "Failed to verify that filter by color (" + color + ") was applied.");
        }

        Assert.assertTrue(colorSize > 0, "No results found for color (" + color + ")");
    }
}
