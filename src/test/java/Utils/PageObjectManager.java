package Utils;

import Pages.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver webDriver;
    private BasePage basePage;
    private Homepage homepage;
    private AccountPage accountPage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public BasePage getBasePage() {
        if (basePage == null) {
            basePage = new BasePage(webDriver);
        }
        return basePage;
    }

    public Homepage getHomepage() {
        if (homepage == null) {
            homepage = new Homepage(webDriver);
        }
        return homepage;
    }

    public AccountPage getAccountPage() {
        if (accountPage == null) {
            accountPage = new AccountPage(webDriver);
        }
        return accountPage;
    }
}