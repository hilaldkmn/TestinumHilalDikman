package Utils;

import Enums.BrowserType;
import Enums.DriverType;
import Enums.Environments;
import org.junit.AfterClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

public class DriverManager {

    private static WebDriver webDriver;
    public static BrowserType browserType;
    public static DriverType driverType;
    public static boolean randomizeBrowsers;
    private static String gridUrl;
    private String baseAddress;



    public DriverManager(){
        if (System.getProperty("browserType") != null) {
            browserType = BrowserType.valueOf(System.getProperty("browserType"));
        }
        if (System.getProperty("driverType") != null) {
            driverType = DriverType.valueOf(System.getProperty("driverType"));
        }
        if (System.getProperty("randomizeBrowsers") != null) {
            randomizeBrowsers = Boolean.parseBoolean(System.getProperty("randomizeBrowsers"));
        }
        if (System.getProperty("gridUrl") != null) {
            gridUrl = System.getProperty("gridUrl");
        }
        loadAddressesByEnvironment();
    }

    private WebDriver createLocalDriver() {
        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver","src\\test\\resources\\drivers\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("disable-notifications");
                options.addArguments("disable-popup-blocking");
                webDriver = new ChromeDriver(options);
                webDriver.navigate().to(baseAddress);
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver","src\\test\\resources\\drivers\\geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                webDriver = new FirefoxDriver(firefoxOptions);
                webDriver.navigate().to(baseAddress);
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver", "src\\test\\resources\\drivers\\msedgedriver.exe");
                EdgeOptions edgeOptions = new EdgeOptions();
                webDriver = new EdgeDriver(edgeOptions);
                webDriver.navigate().to(baseAddress);
                break;
            case SAFARI:
                SafariOptions safariOptions = new SafariOptions();
                webDriver = new SafariDriver(safariOptions);
                webDriver.navigate().to(baseAddress);
                break;
        }
        return webDriver;
    }

    private WebDriver createRemoteDriver(){
        try {
            switch (browserType) {
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("start-maximized");
                    chromeOptions.addArguments("disable-notifications");
                    chromeOptions.addArguments("disable-popup-blocking");
                    chromeOptions.addArguments("--incognito");
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName("chrome");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                    webDriver = new RemoteWebDriver(new URL(gridUrl), capabilities);
                    webDriver.get(baseAddress);
                    break;
                case FIREFOX:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    firefoxOptions.addArguments("-private");
                    DesiredCapabilities capabilitiesFirefox = new DesiredCapabilities();
                    capabilitiesFirefox.setBrowserName("firefox");
                    capabilitiesFirefox.setCapability(ChromeOptions.CAPABILITY, firefoxOptions);
                    webDriver = new RemoteWebDriver(new URL(gridUrl), capabilitiesFirefox);
                    webDriver.get(baseAddress);
                case EDGE:
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.setCapability("InPrivate", true);
                    DesiredCapabilities capabilitiesEdge = new DesiredCapabilities();
                    capabilitiesEdge.setBrowserName("edge");
                    capabilitiesEdge.setCapability(ChromeOptions.CAPABILITY, edgeOptions);
                    webDriver = new RemoteWebDriver(new URL(gridUrl), capabilitiesEdge);
                    webDriver.get(baseAddress);
                    break;
                case SAFARI:
                    SafariOptions safariOptions = new SafariOptions();
                    safariOptions.setCapability("PrivateBrowsing", true);
                    DesiredCapabilities capabilitiesSafari = new DesiredCapabilities();
                    capabilitiesSafari.setBrowserName("safari");
                    capabilitiesSafari.setCapability(ChromeOptions.CAPABILITY, safariOptions);
                    webDriver = new RemoteWebDriver(new URL(gridUrl), capabilitiesSafari);
                    webDriver.get(baseAddress);
                    break;
            }
        }catch (MalformedURLException e){

        }

        return webDriver;
    }

    private WebDriver createDriver(){
        if (randomizeBrowsers) {
            browserType = BrowserType.values()[new Random().nextInt(BrowserType.values().length)];
        }
        if (driverType == DriverType.LOCAL){
            webDriver = createLocalDriver();
        } else if (driverType == DriverType.REMOTE){
            webDriver = createRemoteDriver();
        }
        return webDriver;
    }

    public WebDriver getDriver() {
        if (webDriver == null) webDriver = createDriver();
        return webDriver;
    }

    public void resetDriver() {
        webDriver = null;
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Closing browser");
        webDriver.close();
        webDriver.quit();
    }

    public void loadAddressesByEnvironment() {
        switch (Environments.valueOf(System.getProperty("environment"))) {
            case TEST:
                baseAddress = System.getProperty("testEnvURL");
                break;
            case QA:
                baseAddress = System.getProperty("qaEnvURL");
                break;
            case STAGING:
                baseAddress = System.getProperty("stagingEnvURL");
                break;
            case PROD:
                baseAddress = System.getProperty("prodEnvURL");
                break;
        }
    }
}