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


}
