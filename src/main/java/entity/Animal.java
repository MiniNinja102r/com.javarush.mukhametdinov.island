package entity;

import entity.island.Location;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public abstract class Animal implements Eatable {

    final double weight;
    final Location location;

    void eat(Eatable e) {}

    void move(Location loc) {}

    void multiple() {}

    void die() {}
}
