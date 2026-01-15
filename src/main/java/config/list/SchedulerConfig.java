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
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unchecked")
public final class SchedulerConfig extends Config implements Configurable {

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
            SchedulerConfig.Scheduler.CORE_POOL_SIZE = Configs.getInteger(config, "core_pool_size", 2);
            SchedulerConfig.Scheduler.DELAY = Configs.getLong(config, "delay", 5);
            SchedulerConfig.Scheduler.INITIAL_DELAY = Configs.getLong(config, "initial_delay", 2);
            SchedulerConfig.Scheduler.TIMEUNIT = Configs.getTimeUnit(config, "timeunit", TimeUnit.SECONDS);
        }
    }

    @UtilityClass
    public static class Scheduler {
        public static Integer CORE_POOL_SIZE;
        public static Long DELAY;
        public static Long INITIAL_DELAY;
        public static TimeUnit TIMEUNIT;
    }
}
