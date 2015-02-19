package finance;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ApplicationProperties {

    private static Properties properties;

    private static void loadProperties() {
        properties = new Properties();
        try {
            properties.load(ApplicationProperties.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List getAccountCurrencies() {
        if (properties == null) {
            loadProperties();
        }
        String property = properties.getProperty("account.currencies");
        return Arrays.asList(property.split(","));
    }

    public static List getAccountTypes() {
        if (properties == null) {
            loadProperties();
        }
        String property = properties.getProperty("account.types");
        return Arrays.asList(property.split(","));
    }
}
