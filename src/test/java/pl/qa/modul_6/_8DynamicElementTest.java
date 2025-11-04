package pl.qa.modul_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;

public class _8DynamicElementTest extends BaseTest {

    @Test
    void dynamicElementTest() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_loading/1");
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));
        PlaywrightAssertions.assertThat(text).not().isVisible();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
        PlaywrightAssertions.assertThat(text).isVisible();


    }


    @Test
    void dynamicElementTest2() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_loading/2");
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));
        PlaywrightAssertions.assertThat(text).not().isVisible();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
    }


    @Test
    void dynamicControlsTest() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_controls");
        PlaywrightAssertions.assertThat(page.locator("#input-example input[type=text]")).isVisible();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enable")).click();
        PlaywrightAssertions.assertThat(page.locator("#input-example input[type=text]")).not().isVisible();
    }

    @Test
    void dynamicControlsTest2() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_controls");
        PlaywrightAssertions.assertThat(page.locator("#input-example input[type=text]")).isDisabled();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enable")).click();
        PlaywrightAssertions.assertThat(page.locator("#input-example input[type=text]")).isEnabled();

    }
}
