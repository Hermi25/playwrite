package pl.qa.modul_3;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;

import java.nio.file.Paths;

public class AllBrowserOnet extends BaseTest {
    @Test
    void should_open_browser_onet_chromium() {

        page.navigate("https://www.onet.pl/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/onet_chromium.png")));
        System.out.println(page.title());
    }


    @Test
    void should_open_browser_onet_firefox() {


        page.navigate("https://www.onet.pl/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/onet_firefox.png")));
    }
    @Test
    void should_open_browser_onet_webkit() {

        page.navigate("https://www.onet.pl/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/onet_webkit.png")));
    }

}
