package entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum AnimalType {
    WOLF("\uD83D\uDC3A"),
    BOA_CONSTRICTOR("\uD83D\uDC0D"),
    FOX("\uD83E\uDD8A"),
    BEAR("\uD83D\uDC3B"),
    EAGLE("\uD83E\uDD85"),

    HORSE("🐎"),
    DEER("🦌"),
    RABBIT("🐇"),
    MOUSE("🐁"),
    GOAT("🐐"),
    SHEEP("🐑"),
    BOAR("🐗"),
    BUFFALO("🐃"),
    DUCK("🦆"),
    CATERPILLAR("🐛");

    @Getter
    final String emoji;
}
