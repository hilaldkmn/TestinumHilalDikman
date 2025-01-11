package Steps;

import Pages.BasePage;
import Pages.AccountPage;
import Utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;

import static org.junit.Assert.fail;

public class AccountPageSteps {

    TestContext testContext;
    BasePage basePage;
    AccountPage accountPage;

    public AccountPageSteps(TestContext context) {
        testContext = context;
        basePage = testContext.getPageObjectManager().getBasePage();
        accountPage = testContext.getPageObjectManager().getAccountPage();
    }

    @And("kullanıcının arayuzdeki {string} değeri API'deki balance degeri ile teyit edilir")
    public void checkBalanceIsSameAsDatabase(String balanceLocator) {
        try {
            accountPage.checkBalanceIsSameAsDatabase(balanceLocator);
        } catch (Exception e) {
            fail();
        }
    }

    @And("kullanıcının arayuzdeki {string} değeri API'deki bank_account_name degeri ile teyit edilir")
    public void checkAccountNameIsSameAsDatabase(String nameLocator) {
        try {
            accountPage.checkAccounNameIsSameAsDatabase(nameLocator);
        } catch (Exception e) {
            fail();
        }
    }

    @And("kullanıcının arayuzdeki {string} değeri API'deki bank_account_type degeri ile teyit edilir")
    public void checkAccountTypeIsSameAsDatabase(String typeLocator) {
        try {
            accountPage.checkAccounTypeIsSameAsDatabase(typeLocator);
        } catch (Exception e) {
            fail();
        }
    }
}
