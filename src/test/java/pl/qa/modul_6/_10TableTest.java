package pl.qa.modul_6;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;

import java.util.List;
import java.util.stream.Collectors;

public class _10TableTest extends BaseTest {

    @Test
    void should_return_all_text_from_table() {
        page.navigate("https://the-internet.herokuapp.com/tables");
        List<String> strings = page.locator("table#table1 td").allInnerTexts();

        strings.stream()
                .map(String::trim)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    void should_return_all_text_from_table_2() {
        page.navigate("https://the-internet.herokuapp.com/tables");
        List<Locator> trs = page.locator("table#table1 tr").all();

        List<TableUser> users = trs.stream()
                .map(tr -> {
                    List<Locator> tds = tr.getByRole(AriaRole.CELL).all();
                    String firstName = tds.get(0).innerText();
                    String lastName = tds.get(1).innerText();
                    String userEmail = tds.get(2).innerText();
                    String due = tds.get(3).innerText();
                    String website = tds.get(4).innerText();
                    Locator action = tds.get(5);
                    return new TableUser(firstName, lastName, userEmail, due, website, action);
                })
                .collect(Collectors.toList());

        TableUser frank = users.stream()
                .filter(user -> user.getFirstName().startsWith("Frank"))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User Frank not found"));

        frank.getAction().getByText("edit").click();

        page.waitForTimeout(2000);
    }
}
