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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class LocationTask implements Runnable {

    final Location location;

    public void run() {
        location.getLock().lock();
        try {
            List<Creature> copy = new ArrayList<>(location.getCreatures()
                    .values()
                    .stream()
                    .flatMap(List::stream)
                    .toList());
            Collections.shuffle(copy);

            for (var creature : copy) {
                tickCreature(creature);
            }
        } finally {
            location.getLock().unlock();
        }
    }

    private void tickCreature(Creature creature) {
        if (creature instanceof Animal a) {
            if (a.eat(a.location())) {
                a.reproduce();
            } else {
                a.decreaseSatiety();
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
