package Utils;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigManager {
    public ConfigManager() {
        try {
            Properties p = new Properties();
            p.load(new InputStreamReader(new FileInputStream("config.properties"), StandardCharsets.UTF_8));
            for (String name : p.stringPropertyNames()) {
                String value = p.getProperty(name);
                System.setProperty(name, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
