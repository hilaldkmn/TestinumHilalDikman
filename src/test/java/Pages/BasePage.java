package Pages;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.*;
import java.net.*;
import java.time.Duration;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {

    protected static final Logger logger = LogManager.getLogger();

    private WebDriver webDriver = null;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickWithEvent(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", element);
    }

    public void sendKeys (WebElement element, String text) {
        element.sendKeys(text);
    }

    public void useDownArrow(WebElement element) {
        element.sendKeys(Keys.ARROW_DOWN);
    }

    public void useEnter(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void hoverElement(WebElement element) {
        Actions actions = new Actions (webDriver);
        actions.moveToElement(element).build().perform();
    }

    public String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public WebElement findElement(By by){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return webDriver.findElement(by);
    }

    public void switchSecondTab(){
        ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
    }

    public void clickElementIfExist(By by){
        try{
            WebDriverWait wait = new WebDriverWait(webDriver,  Duration.ofSeconds(15));
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(by));
            el.click();
        } catch (NoSuchElementException err){
        }
    }

    public List<WebElement> findElements(By by){
        WebDriverWait wait = new WebDriverWait(webDriver,  Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return webDriver.findElements(by);
    }

    public void waitUntilElementToBeVisible(By by){
        WebDriverWait wait = new WebDriverWait(webDriver,  Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void assertElementIsVisible(By by){
        WebDriverWait wait = new WebDriverWait(webDriver,  Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void navigateToUrl(String URL){
        webDriver.get(URL);
    }


    public static int formatToInteger(String formattedNumber) {
        if (formattedNumber == null || formattedNumber.isEmpty()) {
            throw new IllegalArgumentException("Invalid input: formattedNumber cannot be null or empty");
        }
        try {
            String cleanedNumber = formattedNumber.replace(",", "").split("\\.")[0];
            return Integer.parseInt(cleanedNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: Unable to parse formattedNumber", e);
        }
    }

    public static double formatToDouble(String formattedNumber) {
        if (formattedNumber == null || formattedNumber.isEmpty()) {
            throw new IllegalArgumentException("Invalid input: formattedNumber cannot be null or empty");
        }
        try {
            // Remove commas and handle the decimal part separately
            String cleanedNumber = formattedNumber.replace(",", "").split("\\.")[0];
            return Double.parseDouble(cleanedNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: Unable to parse formattedNumber", e);
        }
    }


}
