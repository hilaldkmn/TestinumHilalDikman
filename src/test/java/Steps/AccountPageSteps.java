package Steps;

import Pages.BasePage;
import Pages.AccountPage;
import Utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class AccountPageSteps {

    TestContext testContext;
    BasePage basePage;
    AccountPage accountPage;

    public AccountPageSteps(TestContext context) {
        testContext = context;
        basePage = testContext.getPageObjectManager().getBasePage();
        accountPage = testContext.getPageObjectManager().getAccountPage();
    }
}
