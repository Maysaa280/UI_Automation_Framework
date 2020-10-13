package utils;

import org.testng.annotations.DataProvider;

public class DataProviderObject {

    /*
     * Data could easily come from an external file like excel spreadsheet.
     * For the purpose of this demonstration, will keep it simple by hardcoding it :)
     */

    @DataProvider(parallel = true)
    public Object[][] headers() {
        return new Object[][] {
                {"Test_01", "chrome"},
                {"Test_02","chrome"}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] filterColor() {
        return new Object[][] {
                {"Test_01", "chrome", "Women", "Orange"},
                {"Test_02", "chrome", "Women", "Black"},
                {"Test_03", "chrome", "Women", "Blue"},
                {"Test_04", "chrome", "Women", "Yellow"}
        };
    }
}
