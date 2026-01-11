package config;

import java.io.InputStream;

public class Config {

    private static final String CONFIG_PATH = "/config/";

    protected InputStream getInputStream(ConfigType type) {
        return Config.class.getResourceAsStream(CONFIG_PATH + type.getFileName());
    }
}
