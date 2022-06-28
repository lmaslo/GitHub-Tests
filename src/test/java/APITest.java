import config.APIConfig;
import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.get;
import static org.assertj.core.api.Assertions.assertThat;


public class APITest {

    @Test
    @Tag("api")
    void checkStatus200() {
        APIConfig apiConfig = ConfigFactory.create(APIConfig.class, System.getProperties());
        get(apiConfig.getBaseUrl())
                .then()
                .statusCode(200);
    }

    @Test
    @Tag("api")
    void checkToken() throws IOException {
        //Создание файла secret.properties
        //String content = "baseUrl=https://github.com/\ntoken=localToken1";
       // Path propsPath = Paths.get("/tmp/secret.properties");
       // Files.write(propsPath, content.getBytes(StandardCharsets.UTF_8));*/

        APIConfig apiConfig = ConfigFactory.create(APIConfig.class, System.getProperties());
        assertThat(apiConfig.getToken()).isEqualTo("localToken");

        //Удаление временного файла
        //Files.delete(propsPath);
    }
}
