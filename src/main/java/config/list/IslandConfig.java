package config.list;

import config.Config;
import config.ConfigType;
import config.Configs;
import config.Configurable;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Log
@SuppressWarnings("unchecked")
public final class IslandConfig extends Config implements Configurable {

    private static Map<String, Object> data;

    @Override
    public void load(ConfigType cType) {
        try (InputStream input = super.getInputStream(cType)) {
            if (input == null) {
                log.severe("Config file " + cType + " not found.");
                return;
            }
            final Yaml yaml = new Yaml();
            data = yaml.load(input);
            loadConfig(cType);
        } catch (IOException e) {
            log.severe("Error reading configuration: " + e);
        }
    }

    private static void loadConfig(ConfigType cType) {
        final Map<String, Object> config = (Map<String, Object>) data.get(cType.getRawFileName());
        if (config == null)
            log.severe(cType.getRawFileName() + " section not found in config.");
        else {
            Island.X_SIZE = Configs.getInteger(config, "x_size", 1);
            Island.Y_SIZE = Configs.getInteger(config, "y_size", 1);
            Island.MAX_LOCATIONS_ON_ISLAND = Island.X_SIZE * Island.Y_SIZE;
        }
    }

    @UtilityClass
    public static class Island {
        public static Integer X_SIZE;
        public static Integer Y_SIZE;
        public static Integer MAX_LOCATIONS_ON_ISLAND;
    }
}
