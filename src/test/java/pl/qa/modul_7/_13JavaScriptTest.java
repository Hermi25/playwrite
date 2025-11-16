package pl.qa.modul_7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
        import org.assertj.core.api.Assertions;
        import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;


class _13JavaScriptTest extends BaseTest {

    @Test
    void evaluateTest() {
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        String window = (String) page.evaluate("() => window.origin");
        System.out.println("WindowInfo: " + window);
    }
/*
    @Test
    void evalOnSelectorTest() {
        page.navigate("https://the-internet.herokuapp.com/");
        PlaywrightAssertions.assertThat(page.locator("h1[class=heading]")).isVisible();
        page.evalOnSelector("h1[class=heading]", "e => e.remove()");
        page.waitForTimeout(2000);
        PlaywrightAssertions.assertThat(page.locator("h1[class=heading]")).not().isVisible();
    }
*/
    @Test
    void evalOnSelectorAllTest() {
        page.navigate("https://the-internet.herokuapp.com/jqueryui/menu#");
        Integer numberOfLinks = (Integer) page.evalOnSelectorAll("ul li", "e => e.length");
        Assertions.assertThat(numberOfLinks).isEqualTo(8);
    }
}
