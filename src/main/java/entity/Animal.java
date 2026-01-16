package entity;

import config.list.CreatureConfig;
import entity.island.Location;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import repository.CreatureFactory;
import util.Random;

import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public abstract class Animal implements Creature, Moveable, Reproducible {

    @ToString.Exclude
    final double weight;

    @ToString.Exclude
    final Location location;

    @ToString.Exclude
    double saturation;

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
            //location.
        } finally {
            location.getLock().unlock();
        }
    }

    public boolean eat(Location location) {
        boolean isEat = false;
        location.getLock().lock();
        try {
            Optional<Creature> optionalVictim = location.findVictimFor(this.type);
            if (optionalVictim.isPresent()) {
                final Creature victim = optionalVictim.get();
                final double killChance = CreatureConfig.Creature
                        .get(type, CreatureField.getKillChanceField(victim.type()))
                        .doubleValue() / 100;

                if (Random.random.nextDouble() < killChance) {
                    victim.die(DeadReason.KILLED);
                    increaseSatiety(victim.weight());
                    isEat = true;
                }
            }
        } finally {
            location.getLock().unlock();
        }
        return isEat;
    }

    private void increaseSatiety(double increaseWeight) {
        final var maxSaturation = CreatureConfig.Creature.get(this.type, CreatureField.SATURATION).doubleValue();
        this.saturation = Math.max(this.saturation + increaseWeight, maxSaturation);
    }
}
