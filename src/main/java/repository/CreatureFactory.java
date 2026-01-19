package repository;

import entity.Creature;
import entity.CreatureType;
import entity.Plant;
import entity.herbivore.*;
import entity.island.Island;
import entity.island.Location;
import entity.predator.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class CreatureFactory {

    private static final Island island = Island.getInstance();

    public static Creature createCreature(CreatureType type, Location loc) {
        final Creature creature = getCreature(type, loc);
        loc.addCreature(creature);

        return creature;
    }

    private static Creature getCreature(CreatureType type, Location loc) {
        return switch (type) {
            case WOLF -> new Wolf(loc);
            case BOA_CONSTRICTOR -> new BoaConstrictor(loc);
            case FOX -> new Fox(loc);
            case BEAR -> new Bear(loc);
            case EAGLE -> new Eagle(loc);

            case HORSE -> new Horse(loc);
            case DEER -> new Deer(loc);
            case RABBIT -> new Rabbit(loc);
            case MOUSE -> new Mouse(loc);
            case GOAT -> new Goat(loc);
            case SHEEP -> new Sheep(loc);
            case BOAR -> new Boar(loc);
            case BUFFALO -> new Buffalo(loc);
            case DUCK -> new Duck(loc);
            case CATERPILLAR -> new Caterpillar(loc);

            case PLANT -> new Plant(loc);
        };
    }
}
