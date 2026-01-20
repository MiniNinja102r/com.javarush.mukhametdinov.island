package util;

import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@UtilityClass
public final class ConfigGetter {

    public static int getInteger(Map<String, Object> map, String key, int def) {
        Object value = map.get(key);
        if (value instanceof Number num)
            return num.intValue();
        else return def;
    }

    public static long getLong(Map<String, Object> map, String key, long def) {
        Object value = map.get(key);
        if (value instanceof Number num)
            return num.longValue();
        else return def;
    }

    public static double getDouble(Map<String, Object> map, String key, double def) {
        Object value = map.get(key);
        if (value instanceof Number num)
            return num.doubleValue();
        else return def;
    }

    public static TimeUnit getTimeUnit(Map<String, Object> map, String key, TimeUnit def) {
        Object value = map.get(key);
        if (!(value instanceof String s))
            return def;

        try {
            return TimeUnit.valueOf(s.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.printf("Invalid timeunit '%s', using default: %s%n", s, def);
            return def;
        }
    }
}