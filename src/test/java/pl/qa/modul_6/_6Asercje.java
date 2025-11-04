package pl.qa.modul_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;

public class _6Asercje extends BaseTest {

    @Test
    void checkboxTest() {
        page.navigate("https://the-internet.herokuapp.com/checkboxes");
        Locator firstCheckbox = page.getByRole(AriaRole.CHECKBOX).first();
        PlaywrightAssertions.assertThat(firstCheckbox).not().isChecked();
        firstCheckbox.check();
        PlaywrightAssertions.assertThat(firstCheckbox).isChecked();
    }
}

