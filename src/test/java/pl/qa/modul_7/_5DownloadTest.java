package pl.qa.modul_7;

import com.microsoft.playwright.Download;
import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _5DownloadTest extends BaseTest {
    @Test
    void downloadWithHandlerTest() {
        page.navigate("https://the-internet.herokuapp.com/download");

        // HANDLER ZAWSZE PRZEK KLIKNIĘCIEM!
        page.onDownload(download -> download.saveAs(Paths.get("downloads/bucik.txt")));

        // KLIKMAY
        page.getByText("bucik.txt").click();
    }

    @Test
    void downloadWithSaveTest() {
        page.navigate("https://the-internet.herokuapp.com/download");

        // KLIKAMY
        Download download = page.waitForDownload(() -> page.getByText("bucik.txt").click());

        // ZAPISUJEMY
        download.saveAs(Paths.get("downloads/bucik.txt"));
    }
}