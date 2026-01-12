package entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum AnimalType {
    WOLF("Волк"),

    HORSE("Конь");

    @Getter
    final String title;
}
