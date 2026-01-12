package config;

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
            Island.X_SIZE = (Integer) config.get("x_size");
            Island.Y_SIZE = (Integer) config.get("y_size");
        }
    }

    @UtilityClass
    public static class Island {
        public static Integer X_SIZE;
        public static Integer Y_SIZE;
    }
}
