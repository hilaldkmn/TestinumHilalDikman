package Utils;

public class TestContext {

    private final DriverManager driverManager;
    private final PageObjectManager pageObjectManager;
    private final EnvironmentManager environmentManager;


    public TestContext() {
        ConfigManager configManager = new ConfigManager();
        driverManager = new DriverManager();
        pageObjectManager = new PageObjectManager(driverManager.getDriver());
        environmentManager = new EnvironmentManager();
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public EnvironmentManager getEnvironmentManager() {
        return environmentManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

}