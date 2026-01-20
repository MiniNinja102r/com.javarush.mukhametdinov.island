package entity.island;

import config.values.CreatureConfig;
import entity.Creature;
import entity.CreatureField;
import entity.CreatureType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public final class Location {

    @Getter
    final int x;

    @Getter
    final int y;

    final Map<CreatureType, List<Creature>> creatures = new EnumMap<>(CreatureType.class);

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        for (var type : CreatureType.values()) {
            creatures.put(type, new ArrayList<>());
        }
    }

    @Getter
    final ReentrantLock lock = new ReentrantLock();

    public Map<CreatureType, List<Creature>> getCreatures() {
        return Collections.unmodifiableMap(creatures);
    }

    public boolean addCreature(Creature creature) {
        final var type = creature.type();
        if (getCreatureCount(type) >= CreatureConfig.Creature.get(type, CreatureField.MAX_ON_LOCATION).intValue())
            return false;

        this.creatures.get(type).add(creature);
        return true;
    }

    public void removeCreature(Creature creature) {
        creatures.get(creature.type()).remove(creature);
    }

    public int getCreatureCount(CreatureType type) {
        return creatures.get(type).size();
    }

    public Optional<Creature> findVictimFor(CreatureType predatorType) {
        for (var victimType : CreatureType.values()) {
            if (getCreatureCount(victimType) <= 0)
                continue;

            final double killChance = CreatureConfig.Creature
                    .get(predatorType, CreatureField.getKillChanceField(victimType))
                    .doubleValue();

            if (killChance > 0) {
                List<Creature> victims = creatures.get(victimType);
                return Optional.of(victims.getFirst());
            }
        }
        return Optional.empty();
    }
}
