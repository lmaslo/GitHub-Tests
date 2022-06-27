import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    public static WebDriverConfig webConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());


    @BeforeAll
    static void beforeAll() {


        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.browserSize = webConfig.browserSize();
        Configuration.browser = String.valueOf(webConfig.getBrowser());
        Configuration.browserVersion = webConfig.browserVersion();

        if(!webConfig.getRemoteUrl().equals("")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = webConfig.getRemoteUrl();
        }
    }
}
