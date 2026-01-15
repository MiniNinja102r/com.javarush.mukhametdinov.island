package entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum CreatureField {
    WEIGHT("weight"),
    MAX_ON_LOCATION("max_on_location"),
    SPEED("speed"),
    SATURATION("saturation");

    @Getter
    final String configName;
}
