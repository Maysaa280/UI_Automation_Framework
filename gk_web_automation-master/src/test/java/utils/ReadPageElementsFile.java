package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPageElementsFile {

    Properties properties = new Properties();
    String propertyFilePath = System.getProperty("user.dir") + "/src/test/java/page_elements/gk_page_elements.properties";

    public Properties getElementProperties() throws IOException {
        InputStream stream = new FileInputStream(new File(propertyFilePath));
        properties.load(stream);

        return properties;
    }
}
