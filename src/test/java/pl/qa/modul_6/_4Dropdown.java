package pl.qa.modul_6;

import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;

public class _4Dropdown extends BaseTest {
    @Test
    void dropdownTest() {
        page.navigate("https://the-internet.herokuapp.com/dropdown");
        page.selectOption("#dropdown", "Option 1");
        //page.selectOption("#dropdown", "Option 2");
    }

    @Test
    void multipleSelectTest() {
        page.navigate("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        page.getByRole(AriaRole.LISTBOX).selectOption(new String[] {"ms2", "ms3"});
        page.waitForTimeout(3000);
    }



}
