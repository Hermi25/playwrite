package pl.qa.modul_8.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.qa.modul_8.pages.sections.ManageMyAccountSection;

@Getter
public class MyAccountPage extends BasePage {

    private ManageMyAccountSection manageMyAccountSection;

    public MyAccountPage(Page page) {
        super(page);
        this.manageMyAccountSection = new ManageMyAccountSection(page);
    }
}