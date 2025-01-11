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

    public void enterTextToInput(String element, String text) {
        WebElement searchElement = findElement(LocatorManager.getLocator(element));
        if (text.startsWith("[") && text.endsWith("]")) {
            text = System.getProperty(text.substring(1, text.length() - 1));
        }
        sendKeys(searchElement, text);
        logger.info("Entered " + text + " to " + element);
    }

    public void clickButtonOnPage(String element) {
        WebElement buttonElement = findElement(LocatorManager.getLocator(element));
        click(buttonElement);
        logger.info("Clicked on " + element);
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
