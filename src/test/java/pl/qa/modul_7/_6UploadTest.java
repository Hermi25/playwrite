package pl.qa.modul_7;

import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _6UploadTest extends BaseTest {


    @Test
    void uploadSingleFileTest() {
        page.navigate("https://the-internet.herokuapp.com/upload");

        page.setInputFiles("#file-upload", Paths.get("uploads/upload-file.txt"));
        page.setInputFiles("#file-upload", new Path[0]);
        page.setInputFiles("#file-upload", Paths.get("uploads/upload-file_1.txt"));
        page.locator("#file-submit").click();
        assertThat(page.getByText("File Uploaded!")).isVisible();
    }

    @Test
    void uploadMultipleFilesTest() {
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

        page.setInputFiles("#filesToUpload", new Path[]{
                Paths.get("uploads/upload-file.txt"),
                Paths.get("uploads/upload-file_1.txt")
        });

        page.waitForTimeout(3000);
    }
}
