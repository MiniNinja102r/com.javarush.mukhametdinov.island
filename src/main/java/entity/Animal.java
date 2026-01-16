package entity;

import config.list.CreatureConfig;
import entity.island.Location;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import repository.CreatureFactory;

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
        location.getLock().lock();
        try {
            if (location.getCreatureCount(type) >= CreatureConfig.Creature.get(type, CreatureField.MAX_ON_LOCATION).intValue())
                return;

            CreatureFactory.createCreature(type, location);
        } finally {
            location.getLock().unlock();
        }
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
        location.getLock().lock();
        try {
            location.
        } finally {
            location.getLock().unlock();
        }
    }

    public abstract boolean eat(Location location);
}
