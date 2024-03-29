package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigFileReader {

    String CONFIG_FILE_PATH="config/config.properties";

    public String getProperty(String key) throws IOException {
        InputStream input = Files.newInputStream(Paths.get(CONFIG_FILE_PATH));
        Properties prop = new Properties();
        prop.load(input);
        return prop.getProperty(key);
    }
}
