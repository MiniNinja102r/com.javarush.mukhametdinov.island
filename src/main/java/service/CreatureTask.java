package service;

import entity.Animal;
import entity.Creature;
import entity.CreatureType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import repository.CreatureFactory;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class CreatureTask {

    final Creature creature;

    public void run() {
        if (creature instanceof Animal a) {
            if (a.eat())
        } else {
            CreatureFactory.createCreature(CreatureType.PLANT, creature.location());
        }
    }
}
