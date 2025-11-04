package pl.qa.modul_4;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;

import static com.microsoft.playwright.Page.*;

class Homework_4Modul extends BaseTest {
   @Test
   void should_show_error_with_empty_fields() {
      page.navigate("https://the-internet.herokuapp.com/");
      page.getByRole(AriaRole.LINK, new GetByRoleOptions().setName("Form Authentication")).click();
      page.getByRole(AriaRole.BUTTON, new GetByRoleOptions().setName("Login")).click(); // ✅ Fix
      PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!")).isVisible();
   }

   @Test
   void should_show_error_when_login_is_incorrect() {
      page.navigate("https://the-internet.herokuapp.com/");
      page.getByRole(AriaRole.LINK, new GetByRoleOptions().setName("Form Authentication")).click();
      page.getByLabel("Username").fill("smith");
      page.getByLabel("Password").fill("SuperSecretPassword!");
      page.getByRole(AriaRole.BUTTON, new GetByRoleOptions().setName("Login")).click(); // ✅ Fix
      PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!")).isVisible(); // message is "username", not "login"
   }

   @Test
   void should_login_with_incorrect_password() {
      page.navigate("https://the-internet.herokuapp.com/");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Form Authentication")).click();

      page.getByLabel("Username").fill("tomsmith");
      page.getByLabel("Password").fill("SuperSecretPassword!12");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

      PlaywrightAssertions.assertThat(page.getByText("Your password is invalid!")).isVisible();
}}
