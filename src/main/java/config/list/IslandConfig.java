package config.list;

import config.Config;
import config.ConfigType;
import config.Configs;
import config.Configurable;
import exception.ConfigNotFoundException;
import exception.ConfigReadingException;
import lombok.experimental.UtilityClass;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@SuppressWarnings("unchecked")
public final class IslandConfig extends Config implements Configurable {

    private static Map<String, Object> data;

    @Override
    public void load(ConfigType cType) {
        try (InputStream input = super.getInputStream(cType)) {
            if (input == null) {
                throw new ConfigNotFoundException("Config file " + cType + " not found.");
            }
            final Yaml yaml = new Yaml();
            data = yaml.load(input);
            loadConfig(cType);
        } catch (IOException e) {
            throw new ConfigReadingException(e.getMessage());
        }
    }

    private static void loadConfig(ConfigType cType) {
        final Map<String, Object> config = (Map<String, Object>) data.get(cType.getRawFileName());
        if (config == null)
            throw new ConfigReadingException(cType.getRawFileName() + " section not found in config.");
        else {
            Island.X_SIZE = Configs.getInteger(config, "x_size", 1);
            Island.Y_SIZE = Configs.getInteger(config, "y_size", 1);
            Island.MAX_LOCATIONS_ON_ISLAND = Island.X_SIZE * Island.Y_SIZE;
            Island.ANIMAL_MOVE_CHANCE = Configs.getDouble(config, "animal_move_chance", 50);
        }
    }

    @UtilityClass
    public static class Island {
        public static Integer X_SIZE;
        public static Integer Y_SIZE;
        public static Integer MAX_LOCATIONS_ON_ISLAND;
        public static Double ANIMAL_MOVE_CHANCE;
    }
}
