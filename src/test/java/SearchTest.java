import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTest extends TestBase {

    @Test
    void successfulSearchTest() {
        open("");
        $("[name=q]").setValue("lmaslo").pressEnter();
        $(".repo-list").shouldHave(text("lmaslo"));
    }
}
