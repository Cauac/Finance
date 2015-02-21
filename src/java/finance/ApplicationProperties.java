package finance;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ApplicationProperties {

    private static Properties properties;
    private static List<String> currencies;
    private static List<String> accountTypes = Arrays.asList("наличные", "банк. счет");

    public static List<String> getAccountCurrencies() {
        if (currencies == null) {
            String property = getProperty("account.currencies");
            currencies = Arrays.asList(property.split(","));
        }
        return currencies;
    }

    public static List<String> getAccountTypes() {
        return accountTypes;
    }

    private static String getProperty(String propertyName) {
        if (properties == null) {
            try {
                properties = new Properties();
                properties.load(ApplicationProperties.class.getClassLoader().getResourceAsStream("application.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(propertyName);
    }
}
