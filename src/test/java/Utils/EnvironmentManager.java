package Utils;

import Enums.DriverType;
import Enums.Environments;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class EnvironmentManager {

    public Environments currentEnvironment;

    public EnvironmentManager(){
    }

    public Environments getCurrentEnvironment() {
        return currentEnvironment;
    }

    public void setCurrentEnvironment(Environments env) {
        this.currentEnvironment = env;
    }

}