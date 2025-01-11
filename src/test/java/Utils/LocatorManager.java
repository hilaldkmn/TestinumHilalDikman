package Utils;

import Models.Locator;
import com.google.gson.Gson;
import org.openqa.selenium.By;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class LocatorManager {
    private static final Map<String, By> locatorsMap = new HashMap<>();

    static {
        loadLocatorsFromJsonFiles();
    }

    private static void loadLocatorsFromJsonFiles() {
        String resourcesPath = "src/test/resources/page-objects";
        File folder = new File(resourcesPath);

        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("Folder does not exist or is not a directory: " + resourcesPath);
        }

        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));

        if (files == null) {
            throw new RuntimeException("Failed to list files in folder: " + resourcesPath);
        }

        Gson gson = new Gson();
        for (File file : files) {
            try (FileReader reader = new FileReader(file)) {
                Locator[] locatorData = gson.fromJson(reader, Locator[].class);
                for (Locator entry : locatorData) {
                    String key = entry.getLocatorName();
                    String value = entry.getLocator();
                    String locatorType = entry.getLocatorType();
                    By by = getByFromType(locatorType, value);
                    locatorsMap.put(key, by);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static By getByFromType(String type, String value) {
        return switch (type.toLowerCase()) {
            case "id" -> By.id(value);
            case "css" -> By.cssSelector(value);
            case "xpath" -> By.xpath(value);
            case "classname" -> By.className(value);
            default -> throw new IllegalArgumentException("Unsupported locator type: " + type);
        };
    }

    public static By getLocator(String key) {
        return locatorsMap.get(key);
    }
}
