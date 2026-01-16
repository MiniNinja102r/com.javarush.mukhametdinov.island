import config.Config;
import config.list.CreatureConfig;
import config.list.IslandConfig;
import entity.Creature;
import entity.CreatureField;
import entity.CreatureType;
import entity.Plant;
import entity.island.Island;
import entity.island.Location;
import entity.predator.Bear;
import entity.predator.Wolf;
import repository.CreatureFactory;

import java.util.Map;

public final class Launcher {

    public static void main(String[] args) {
        Config.loadAll();

        final Location[] locations = loadLocations();
        Island.initialize(locations);
        loadCreatures(locations);

        broadcastPopulation(locations);

        Creature creature1 = CreatureFactory.createCreature(CreatureType.WOLF);
        Wolf wolf = (Wolf) creature1;
        wolf.eat(locations[0]);

        System.out.println("-".repeat(100));

        Creature creature2 = CreatureFactory.createCreature(CreatureType.BEAR);
        Bear bear = (Bear) creature2;
        bear.eat(locations[0]);
    }

    private static Location[] loadLocations() {
        final Location[] locations = new Location[IslandConfig.Island.MAX_LOCATIONS_ON_ISLAND];
        int it = 0;
        for (int i = 1; i <= IslandConfig.Island.X_SIZE; i++) {
            for (int j = 1; j <= IslandConfig.Island.Y_SIZE; j++) {
                var loc = new Location(i, j);
                locations[it] = loc;
                it++;
            }
        }
        return locations;
    }

    private static void loadCreatures(Location[] locations) {
        for (var loc : locations) {
            for (var type : CreatureType.values()) {
                int initCount = (CreatureConfig.Creature.get(type, CreatureField.INITIAL_COUNT)).intValue();
                for (int k = 0; k < initCount; k++) {
                    CreatureFactory.createCreature(type, loc);
                }
            }
        }
    }

    //TEST
    private static void broadcastPopulation(Location[] locations) {
        for (Location location : locations) {
            final Map<Creature, Integer> creatures = location.getCreatures();
            for (CreatureType type : CreatureType.values()) {
                int count = 0;
                for (var entry : creatures.entrySet()) {
                    if (entry.getKey().type() == type)
                        count += entry.getValue();
                }
                System.out.printf("%s: %d, ", type.getEmoji(), count);
            }
        }
        System.out.printf("%n");
    }
}