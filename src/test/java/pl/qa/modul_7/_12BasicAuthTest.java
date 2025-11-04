package pl.qa.modul_7;

import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class _12BasicAuthTest extends BaseTest {

    @Test
    void basicAuthTest() {
        page.navigate("https://the-internet.herokuapp.com/basic_auth");
        assertThat(page.getByText("Congratulations! You must have the proper credentials.")).isVisible();
    }
}
