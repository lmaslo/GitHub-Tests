package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${type}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    String getBaseUrl();

    @Key("browser")
    Browser getBrowser();

    @Key("browserVersion")
    String browserVersion();
}
