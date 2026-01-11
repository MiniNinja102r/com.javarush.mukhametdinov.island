package config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ConfigType {
    SETTINGS("settings.yml");

    @Getter
    private final String fileName;
}
