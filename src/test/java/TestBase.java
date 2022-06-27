import com.codeborne.selenide.Configuration;
import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    public static WebDriverConfig webConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.browserSize = "1920x1080";
        Configuration.browser = String.valueOf(webConfig.getBrowser());
        Configuration.browserVersion = webConfig.browserVersion();
    }
}
