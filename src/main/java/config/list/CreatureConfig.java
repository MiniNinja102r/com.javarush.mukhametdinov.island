package config.list;

import config.Config;
import config.ConfigType;
import config.Configurable;
import entity.CreatureField;
import entity.CreatureType;
import exception.ConfigNotFoundException;
import exception.ConfigReadingException;
import lombok.experimental.UtilityClass;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.EnumMap;
import java.util.Map;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public final class CreatureConfig extends Config implements Configurable {

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
            for (var creatureType : CreatureType.values()) {
                parseCreature(creatureType, config);
            }
        }
    }

    private static void parseCreature(CreatureType creatureType, Map<String, Object> data) {
        final String section = creatureType.toString().toLowerCase();
        var obj = data.get(section);
        if (obj == null)
            return;
        var creatureInfo = (Map<String, Number>) obj;
        Creature.put(creatureType, creatureInfo);
    }

    @UtilityClass
    public static class Creature {

        static Map<CreatureType, Map<String, Number>> creaturesData = new EnumMap<>(CreatureType.class);

        private static void put(CreatureType type, Map<String, Number> data) {
            if (data == null || data.isEmpty())
                return;
            creaturesData.put(type, data);
        }

        public static Number get(CreatureType type, CreatureField field) {
            var data = creaturesData.get(type);
            if (data != null && !data.isEmpty())
                return data.get(field.getConfigName());
            throw new NoSuchElementException("No data found for type: " + type + ", and field: " + field);
        }
    }
}