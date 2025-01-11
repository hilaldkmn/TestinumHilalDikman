package Steps;

import Pages.AccountPage;
import Pages.BasePage;
import Pages.Homepage;
import Utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static org.junit.Assert.*;



public class HomepageSteps {

    TestContext testContext;
    BasePage basePage;
    Homepage homepage;
    AccountPage accountPage;


    @Before
    public void setUp() {
        testContext.getDriverManager().getDriver();

    }

    @After
    public void tearDown(Scenario scenario) {
        if (testContext.getDriverManager().getDriver() != null) {
            testContext.getDriverManager().getDriver().quit();
            testContext.getDriverManager().resetDriver();
        }
    }

    public HomepageSteps(TestContext context) {
        testContext = context;
        basePage = testContext.getPageObjectManager().getBasePage();
        homepage = testContext.getPageObjectManager().getHomepage();
        accountPage = testContext.getPageObjectManager().getAccountPage();
    }

    @Given("kullanıcı CatchyLabs giriş sayfasındadır")
    public void checkUserInHomepage() {
        homepage.checkUserInHomepage();
    }

    @And("kullanıcı {string} alanına {string} yazar")
    public void enterTextToInput(String element, String text) {
        homepage.enterTextToInput(element, text);
    }


    @And("kullanıcı {string} butonuna tıklar")
    public void clickButtonOnPage(String element) {
        homepage.clickButtonOnPage(element);
    }

    @And("kullanıcının giriş yaptığı görülür")
    public void checkUserLoggedIn() {
        homepage.checkUserLoggedIn();
    }

    @And("kullanıcının çıkış yaptığı görülür")
    public void checkUserLoggedOut() {
        homepage.checkUserLoggedOut();
    }



}
