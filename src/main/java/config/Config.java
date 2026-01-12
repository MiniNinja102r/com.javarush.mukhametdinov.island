package config;

import config.list.IslandConfig;

import java.io.InputStream;
import java.util.List;

public class Config {

    private static final String CONFIG_PATH = "/config/";

    private static final List<Configurable> CONFIGS = List.of(
            new IslandConfig()
    );

    protected InputStream getInputStream(ConfigType type) {
        return Config.class.getResourceAsStream(CONFIG_PATH + type.getFileName());
    }

    public static void loadAll() {
        for (int i = 0; i < CONFIGS.size(); i++) {
            final Configurable config = CONFIGS.get(i);
            final ConfigType[] values = ConfigType.values();
            config.load(values[i]);
        }
    }
}
