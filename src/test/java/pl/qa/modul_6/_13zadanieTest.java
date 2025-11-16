package pl.qa.modul_6;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class _13zadanieTest extends BaseTest {

    @Test
    void price_should_not_be_lower_or_equal_than_15() {
        List<Product> products = getProducts();
        // używamy getPrice() (double) i sprawdzamy > 15.0
        assertThat(products).allMatch(p -> p.getPrice() > 15.0);
    }

    @Test
    void should_verify_all_product_names_contains_printed() {
        List<Product> products = getProducts();
        assertThat(products).allMatch(p -> p.getName().contains("Printed"));
    }

    private List<Product> getProducts() {
        // bez klikania w menu — otwieramy bezpośrednio kategorię DRESSES
        page.navigate("http://www.automationpractice.pl/index.php?id_category=8&controller=category");

        List<Locator> productLocators = page.locator(".product_list .ajax_block_product").all();
        List<Product> products = new ArrayList<>();

        for (Locator p : productLocators) {
            // pobierz cenę jako tekst, usuń $ i spacje, parsuj jako double
            String priceText = p.locator(".right-block .content_price .price").innerText().trim();
            // np. "16.51" albo "$16.51" -> usuwamy dolara
            priceText = priceText.replace("$", "").replace("€", "").trim();

            double price;
            try {
                price = Double.parseDouble(priceText);
            } catch (NumberFormatException e) {
                // jeśli coś dziwnego w tekście, ustaw 0.0 i wypisz debug
                System.out.println("Cannot parse price: '" + priceText + "'; defaulting to 0.0");
                price = 0.0;
            }

            String name = p.locator(".right-block .product-name").innerText().trim();
            products.add(new Product(name, price));
        }

        // debug: pokaż zebrane produkty
        products.forEach(System.out::println);

        return products;
    }
}
