package pl.qa.modul_8;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;
import pl.qa.modul_8.pages.BasePage;
import pl.qa.modul_8.pages.CreateAnAccountPage;
import pl.qa.modul_8.pages.HomePage;
import pl.qa.modul_8.pages.MyAccountPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CreateAnAccountTest extends BaseTest {

        private HomePage homePage;
        private Faker faker;

        @BeforeEach
        void beforeEach() {
            faker = new Faker();
            homePage = new HomePage(page);
            page.navigate("http://www.automationpractice.pl/");
        }

        @Test
        void should_create_new_account_test() {
            CreateAnAccountPage createAnAccountPage = homePage.getTopMenuSection().clickSignInLink();

            createAnAccountPage.getCreateAnAccountFormSection()
                    .enterEmail(faker.internet().emailAddress())
                    .clickCreateAnAccountButton();

            MyAccountPage myAccountPage = createAnAccountPage.getCreateAnAccountFormSection()
                    .checkGenderMr()
                    .enterFirstName("Iga")
                    .enterLastName("Buka")
                    .enterPassword("123456")
                    .setDateOfBirth("6", "9", "1992")
                    .clickRegisterButton();

            assertThat(myAccountPage.getManageMyAccountSection().getLocators().accountCreatedMessage()).isVisible();
            assertThat(myAccountPage.getManageMyAccountSection().getLocators().myAccountLabel()).hasText("My account");
        }
    }