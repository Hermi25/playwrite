package pl.qa.modul_6;

import org.junit.jupiter.api.Test;
import pl.qa.common.BaseTest;

public class _2InputTest extends BaseTest {
    @Test
    void inputTest() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.fill("#username", "iga"); // wkleja caly text
        page.fill("#password", "123456"); // wpisuje znak po znaku

      //  page.fill("","wartosc",new Page.FillOptions().setForce(true)); // omijanie sprawdzenia czy element nie jest przysłoniety innym elementem - jesli jest to setforce pozwoli wpisac wartosc
    }
    
}
