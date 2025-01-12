package Steps;

import Pages.BasePage;
import Pages.AccountPage;
import Utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;

import java.text.ParseException;

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

    @And("kullanıcının {string} elementinde {string} metnini gördüğü doğrulanır")
    public void verifyTextOnPage(String element, String expectedText) {
        try {
            basePage.assertElementContainsSpecificText(element, expectedText);
        } catch (Exception e){
            System.out.println(e.getMessage());
            fail();
        }
    }

    @And("API balance değeri hafızaya alınır")
    public void storeBalance() throws ParseException {
        accountPage.storedBalanceIsSameAsDatabase();
    }

    @And("API balance değeri hafızadaki değer ile karşılaştırılır")
    public void compareBalanceWithAPI() {
        accountPage.verifyStoredBalanceWithAPI();
    }

    @And("Kullanıcı {string} tutarını gönderdiğinde kalan bakiye doğru hesaplanmalıdır")
    public void checkAmountSentBalanceWithAPI(String element){
        accountPage.checkAmountSentBalanceWithAPI(element);
    }

    @And("Kullanıcı {string} tutarını kendine gönderdiğinde kalan bakiye doğru hesaplanmalıdır")
    public void checkAmountReceiveBalanceWithAPI(String element){
        accountPage.checkAmountReceiveBalanceWithAPI(element);
    }

    @And("kullanıcının yaptığı işlem miktarı {double} olarak API den teyit edilir")
    public void compareTxAmountWithAPI(double amount){
        accountPage.compareTxAmountWithAPI(amount);
    }

    @And("kullanıcının islemi gonderen {string} olarak API den teyit edilir")
    public void compareTxSenderWithAPI(String sender){
        accountPage.compareTxSenderWithAPI(sender);
    }

    @And("kullanıcının islemi alici {string} olarak API den teyit edilir")
    public void compareTxReceiverWithAPI(String receive){
        accountPage.compareTxReceiverWithAPI(receive);
    }

}
