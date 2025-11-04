package pl.qa.modul_7;

import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;

public class _2ShadowDOMTest extends BaseTest {

    @Test
    void ShadowDOMTest() {
        page.navigate("https://the-internet.herokuapp.com/shadowdom");
        System.out.println(page.locator("span[slot=my-text]").innerText());
    }

    @Test
    void ShadowDOMTest2() {
        page.navigate("https://bugs.chromium.org/p/chromium/issues/list");
        page.selectOption("#can", "New Issues");
    }

}
