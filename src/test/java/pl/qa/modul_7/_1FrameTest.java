
package pl.qa.modul_7;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _1FrameTest extends BaseTest {

    @Test
    void should_enter_text_in_iframe() {
        page.navigate("https://the-internet.herokuapp.com/iframe");
        page.frameLocator("#mce_0_ifr").locator("#tinymce").fill("Test");
    }

    @Test
    void should_get_text_from_nested_frames() {
        page.navigate("https://the-internet.herokuapp.com/nested_frames");

        assertThat(page.frameLocator("frame[name='frame-middle']").locator("#content"))
                .containsText("Middle");
    }
}
