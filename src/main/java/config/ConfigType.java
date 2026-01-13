package config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ConfigType {
    ISLAND("island.yml"),
    SCHEDULER("scheduler.yml"),
    CREATURE("creature.yml");

    @Getter
    private final String fileName;

    private static final String YML_FORMAT = ".yml";

    public String getRawFileName() {
        String raw = this.getFileName();
        if (raw.contains(YML_FORMAT))
            return raw.substring(0, raw.length() - YML_FORMAT.length());
        return raw;
    }
}
