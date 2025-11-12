package pl.qa.modul_8;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;
import pl.qa.modul_8.dto.ContactUsDTO;
import pl.qa.modul_8.pages.ContactUsPage;
import pl.qa.modul_8.pages.HomePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SendContactUsFormTest extends BaseTest {
    private HomePage homePage;

    public SendContactUsFormTest(Page page) {
        super(page);
    }

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate("http://www.automationpractice.pl/");
    }

    @Test
    void should_show_an_error_when_trying_to_send_empty_form_test() {
        ContactUsPage contactUsPage = homePage.getTopMenuSection().clickOnContactUsLink();
        contactUsPage.getContactUsFormSection().clickOnSendMessageButton();
        assertThat(contactUsPage.getContactUsFormSection().getErrorMessage()).isVisible();
    }


    @Test
    void should_fill_and_send_contact_us_form_test() {
        ContactUsPage contactUsPage = homePage.getTopMenuSection().clickOnContactUsLink();
        contactUsPage.getContactUsFormSection().sendContactUsForm(ContactUsDTO.getDefaultContactUsDTO());
        assertThat(contactUsPage.getContactUsFormSection().getConfirmationMessage()).isVisible();
    }
}


