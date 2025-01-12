package Pages;

import Services.AccountService;
import Utils.LocatorManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class AccountPage extends BasePage {
    protected static final Logger logger = LogManager.getLogger();
    private double storedBalance = 0.0;

    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void checkBalanceIsSameAsDatabase(String balanceLocator) throws ParseException {
        WebElement balanceElement = findElement(LocatorManager.getLocator(balanceLocator));
        double balance = formatToDouble(getText(balanceElement));
        Map<String, Object> accountInformation = AccountService.getAccountInformation();
        double balanceFromDatabase = (double) accountInformation.get("balance");
        logger.info("Checking if balance is the same as in the database");
        assertEquals(balance, balanceFromDatabase, 0.0);
    }

    public void checkAccounNameIsSameAsDatabase(String nameLocator) throws ParseException {
        WebElement nameElement = findElement(LocatorManager.getLocator(nameLocator));
        String name = getText(nameElement);
        Map<String, Object> accountInformation = AccountService.getAccountInformation();
        String nameFromDatabase = (String) accountInformation.get("bank_account_name");
        logger.info("Checking if Account Name is the same as in the database");
        assertEquals(name, nameFromDatabase);
    }

    public void checkAccounTypeIsSameAsDatabase(String typeLocator) throws ParseException {
        WebElement typeElement = findElement(LocatorManager.getLocator(typeLocator));
        String type = getText(typeElement);
        Map<String, Object> typeInformation = AccountService.getAccountInformation();
        String typeFromDatabase = (String) typeInformation.get("bank_account_type");
        logger.info("Checking if Type Name is the same as in the database");
        assertEquals(type, typeFromDatabase);
    }

    public void storedBalanceIsSameAsDatabase() throws ParseException {
        Map<String, Object> accountInformation = AccountService.getAccountInformation();
        double balanceFromDatabase = (double) accountInformation.get("balance");
        storedBalance = balanceFromDatabase;
        System.out.println("ilk "+storedBalance);
        logger.info(" | API Balance: " + balanceFromDatabase);
    }

    public void verifyStoredBalanceWithAPI(){
        Map<String, Object> accountInformation = AccountService.getAccountInformation();
        double balanceFromDatabase = (double) accountInformation.get("balance");
        System.out.println("son "+balanceFromDatabase);
        assertEquals(balanceFromDatabase, storedBalance, 0.0);
        logger.info("Stored Balance (API’den gelen önceki değer): " + storedBalance);
    }

    public void checkAmountSentBalanceWithAPI(String amountSent){
        double dblamountSent = Double.parseDouble(amountSent);
        Map<String, Object> accountInformation = AccountService.getAccountInformation();
        double balanceFromDatabase = (double) accountInformation.get("balance");
        double endbalance = storedBalance - dblamountSent;
        System.out.println("son "+endbalance);
        System.out.println("eski "+storedBalance);
        assertEquals(storedBalance, endbalance, 0.0);
        logger.info("Stored Balance (API’den gelen önceki değer): " + storedBalance);
    }

}
