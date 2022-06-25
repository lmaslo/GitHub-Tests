import com.codeborne.selenide.Configuration;
import config.Browser;
import config.WebDriverConfig;
import config.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTest {

    public static WebDriverConfig webConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = String.valueOf(webConfig.getBrowser());
    }


    @Test
    void successfulSearchTest() {
        open("");
        $("[name=q]").setValue("lmaslo").pressEnter();
        $(".repo-list").shouldHave(text("lmaslo"));
    }
}
