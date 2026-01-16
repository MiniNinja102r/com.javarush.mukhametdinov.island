package entity.island;

import entity.Creature;
import entity.CreatureType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public final class Location {

    final int x;
    final int y;
    final Map<Creature, Integer> creatures = new HashMap<>();

    @Getter
    final ReentrantLock lock = new ReentrantLock();

    public Map<Creature, Integer> getCreatures() {
        return Collections.unmodifiableMap(creatures);
    }

    public void addCreature(Creature creature) {
        this.creatures.merge(creature, 1, Integer::sum);
    }

    public int getCreatureCount(CreatureType type) {
        final AtomicInteger sum = new AtomicInteger();
        getCreatures().forEach((cr, a) -> {
            if (cr.type() == type)
                sum.addAndGet(creatures.get(cr));
        });
        return sum.get();
    }
}
