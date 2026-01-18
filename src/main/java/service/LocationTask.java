package service;

import config.list.IslandConfig;
import entity.Animal;
import entity.Creature;
import entity.CreatureType;
import entity.island.Location;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import repository.CreatureFactory;
import util.Random;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class LocationTask implements Runnable {

    final Location location;

    public void run() {
        location.getLock().lock();
        try {
            for (var type : CreatureType.values()) {
                for (var creature : location.getCreatures().get(type)) {
                    tickCreature(creature);
                }
            }
        } finally {
            location.getLock().unlock();
        }
    }

    private void tickCreature(Creature creature) {
        if (creature instanceof Animal a) {
            if (a.eat(a.location())) {
                a.reproduce();
            }
            tryMove(a);
        } else {
            CreatureFactory.createCreature(CreatureType.PLANT, creature.location());
        }
    }

    private void tryMove(Animal animal) {
        final double moveChance = IslandConfig.Island.ANIMAL_MOVE_CHANCE;
        if (Random.getRandom().nextDouble() < moveChance) {
            animal.move(animal.location());
        }
    }
}
