package entity;

import entity.island.Location;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public abstract class Animal implements Creature, Moveable, Reproducible {

    @ToString.Exclude
    final double weight;

    @ToString.Exclude
    final Location location;

    @Getter
    final CreatureType type;

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public Location location() {
        return location;
    }

    @Override
    public void reproduce() {
    }

    @Override
    public CreatureType type() {
        return type;
    }

    @Override
    public void move(Location location) {
    }

    @Override
    public void die(DeadReason reason) {
    }

    public abstract void eat(Eatable e);
}
