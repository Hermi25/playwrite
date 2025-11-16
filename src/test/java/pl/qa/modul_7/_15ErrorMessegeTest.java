package pl.qa.modul_7;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _15ErrorMessegeTest extends BaseTest {

    private Playwright pw = Playwright.create();
    private Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));


    // test z robieniem screenshota przy bledzie w formularzu Contact us
    @Test
    void errorMessageTest() {
        page.navigate("http://www.automationpractice.pl/index.php");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us")).click();
        page.locator("#submitMessage").click();

        assertThat(page.getByText("Invalid email address.")).isVisible();

        page.locator("#center_column").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshots/empty_contact_us_form.png")));
    }

    // test  z uzupelnieniem formularza Contact us

    @Test
    void should_fill_and_send_contact_us_form() {
        page.navigate("http://www.automationpractice.pl/index.php");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us")).click();
        page.locator("#id_contact").selectOption("Customer service");
        page.locator("#email").fill("demouser@buka.pl");
        page.locator("#id_order").fill("123456");
        page.locator("#message").fill("test message");
        page.locator("#submitMessage").click();
    }
}

