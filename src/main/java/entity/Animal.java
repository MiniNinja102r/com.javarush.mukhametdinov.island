package entity;

import entity.island.Location;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Animal implements Eatable {

    final double weight;

    void eat(Eatable e) {}

    void move(Location loc) {}

    void multiple() {}

    void die() {}
}
