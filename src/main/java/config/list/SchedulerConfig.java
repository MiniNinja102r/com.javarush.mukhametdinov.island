package config.list;

import config.Config;
import config.ConfigType;
import config.Configurable;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Log
@SuppressWarnings("unchecked")
public final class SchedulerConfig extends Config implements Configurable {

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
            SchedulerConfig.Scheduler.CORE_POOL_SIZE = (Integer) config.get("core_pool_size");
        }
    }

    @UtilityClass
    public static class Scheduler {
        public static Integer CORE_POOL_SIZE;
    }
}
