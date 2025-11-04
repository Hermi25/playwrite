package pl.qa.modul_7;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;

public class _8VideoRecordingTest extends BaseTest {
    @Test
    void videoTest() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.fill("#username", "demouser");
        page.type("#password", "haslo123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
