package entity;

import config.values.CreatureConfig;
import config.values.IslandConfig;
import entity.island.Island;
import entity.island.Location;
import lombok.*;
import lombok.experimental.FieldDefaults;
import repository.CreatureFactory;
import util.Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
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
        CreatureFactory.createCreature(type, location);
    }

    @Override
    public CreatureType type() {
        return type;
    }

    @Override
    public void move(Location location, Island island) {
        final Location moveLoc = chooseMoveLocation(island);
        final Location previousLoc = this.location;

        if (moveLoc == null) return;

        if (moveLoc.addCreature(this)) {
            previousLoc.removeCreature(this);
        }
    }

    @Override
    public void die(DeadReason reason) {
        location.removeCreature(this);
    }

    private Location chooseMoveLocation(Island island) {
        final int x = location.getX();
        final int y = location.getY();

        List<Location> variants = new ArrayList<>(4);
        final int speed = CreatureConfig.Creature.get(this.type, CreatureField.SPEED).intValue();

        addIfValid(island, variants, x + speed, y);
        addIfValid(island, variants, x - speed, y);
        addIfValid(island, variants, x, y + speed);
        addIfValid(island, variants, x, y - speed);
        if (variants.isEmpty())
            return null;

        return variants.get(Random.getRandom().nextInt(variants.size()));
    }

    private void addIfValid(Island island, List<Location> list, int x, int y) {
        if (x < 1 || y < 1 || x > IslandConfig.Island.X_SIZE || y > IslandConfig.Island.Y_SIZE)
            return;

        Location loc = island.getLocation(x, y);
        if (loc != null) {
            list.add(loc);
        }
    }

    public boolean eat(Location location) {
        if (this.saturation == CreatureConfig.Creature.get(this.type, CreatureField.SATURATION).doubleValue())
            return false;

        Optional<Creature> optionalVictim = location.findVictimFor(this.type);
        if (optionalVictim.isEmpty())
            return false;

        final Creature victim = optionalVictim.get();
        final double killChance = CreatureConfig.Creature
                .get(this.type, CreatureField.getKillChanceField(victim.type()))
                .doubleValue() / 100;

        if (Random.getRandom().nextDouble() < killChance) {
            increaseSatiety(victim.weight());
            victim.die(DeadReason.KILLED);
            return true;
        }

        return false;
    }

    public void increaseSatiety(double increaseWeight) {
        final var maxSaturation = CreatureConfig.Creature.get(this.type, CreatureField.SATURATION).doubleValue();
        this.saturation = Math.min(this.saturation + increaseWeight, maxSaturation);
    }

    public void decreaseSatiety() {
        final double decreaseWeight = CreatureConfig.Creature
                .get(this.type, CreatureField.HUNGER_PER_TICK)
                .doubleValue();

        this.saturation = Math.max(0, this.saturation - decreaseWeight);
        if (this.saturation <= 0)
            this.die(DeadReason.HUNGER);
    }
}
