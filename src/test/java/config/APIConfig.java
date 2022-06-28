package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/tmp/secret.properties",
        "classpath:api.properties"
})
public interface APIConfig extends Config {
    @Key("baseUrl")
    String getBaseUrl();

    @Key("token")
    String getToken();

}
