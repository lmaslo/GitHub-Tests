package config;

import org.aeonbits.owner.Config;

public interface WebDriverConfig extends Config {
    @Key("browser")
    @DefaultValue("FIREFOX")
    Browser getBrowser();
}
