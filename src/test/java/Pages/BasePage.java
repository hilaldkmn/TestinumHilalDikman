package Pages;

import Utils.LocatorManager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
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

import static org.junit.Assert.fail;

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

    public void acceptAlertIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.alertIsPresent()); // Alert'in var olup olmadığını kontrol et
            Alert alert = webDriver.switchTo().alert(); // Alert'e geçiş yap
            logger.info("Alert mesajı: " + alert.getText()); // Konsola alert mesajını yazdır
            alert.accept(); // "Tamam" butonuna bas
            logger.info("Alert kapatıldı.");
        } catch (NoAlertPresentException e) {
            logger.info("Herhangi bir alert bulunamadı.");
        }
    }

    public void verifyAndAcceptAlertOrFail() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent()); // Alert'in var olup olmadığını kontrol et

            Alert alert = webDriver.switchTo().alert(); // Alert'e geçiş yap
            logger.info("Alert mesajı: " + alert.getText()); // Konsola alert mesajını yazdır

            alert.accept(); // "Tamam" butonuna bas
            logger.info("Alert kapatıldı.");
        } catch (TimeoutException e) {
            logger.error("Beklenen alert bulunamadı, test başarısız!");
            fail("Beklenen alert ekranda görünmedi!"); // Testi başarısız yap
        }
    }

    public void waitForSeconds(String seconds) {
        try {
            int waitTime = Integer.parseInt(seconds); // String'i integer'a çevir
            Thread.sleep(waitTime * 1000); // Milisaniyeye çevirerek beklet
            logger.info(waitTime + " saniye bekleniyor...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Thread'in kesildiğini belirt
            logger.error("Bekleme sırasında hata oluştu!", e);
        } catch (NumberFormatException e) {
            logger.error("Geçersiz süre formatı: " + seconds, e);
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

    public void enterTextToInput(String element, String text) {
        WebElement searchElement = findElement(LocatorManager.getLocator(element));
        if (!searchElement.getAttribute("value").isEmpty()) {
            searchElement.clear();
        }
        if (text.startsWith("[") && text.endsWith("]")) {
            text = System.getProperty(text.substring(1, text.length() - 1));
        }
        sendKeys(searchElement, text);
        logger.info("Entered '" + text + "' into '" + element + "'");
    }

    public void clickButtonOnPage(String element) {
        WebDriverWait wait = new WebDriverWait(webDriver,  Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(LocatorManager.getLocator(element)));
        WebElement buttonElement = findElement(LocatorManager.getLocator(element));
        click(buttonElement);
        logger.info("Clicked on " + element);
    }

    public void assertElementContainsSpecificText(String element, String expectedText) {
        WebElement webElement = findElement(LocatorManager.getLocator(element));
        String text = webElement.getText();
        Assert.assertTrue("Beklenen metin bulunamadı!", text.contains(expectedText));
    }
}
