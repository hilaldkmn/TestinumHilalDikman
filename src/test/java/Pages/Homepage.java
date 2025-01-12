package Pages;

import Utils.LocatorManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;


public class Homepage extends BasePage {
    protected static final Logger logger = LogManager.getLogger();
    public Homepage(WebDriver webDriver) {
        super(webDriver);
    }


    public void checkUserLoggedIn() {
        WebElement userElement = findElement(LocatorManager.getLocator("logoutButton"));
        logger.info("checking if user is logged in");
        assertTrue(userElement.isDisplayed());
    }

    public void checkUserLoggedOut() {
        WebElement userElement = findElement(LocatorManager.getLocator("loginButton"));
        logger.info("checking if user is logged out");
        assertTrue(userElement.isDisplayed());
    }

    public void checkUserInHomepage() {
        WebElement userElement = findElement(LocatorManager.getLocator("loginButton"));
        logger.info("checking if user is in homepage");
        assertTrue(userElement.isDisplayed());
    }



}
