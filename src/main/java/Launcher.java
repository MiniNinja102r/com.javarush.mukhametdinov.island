import config.Config;
import config.list.CreatureConfig;
import config.list.IslandConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Island;
import entity.island.Location;
import repository.CreatureFactory;

public final class Launcher {

    public static void main(String[] args) {
        Config.loadAll();

        Island.initialize(loadLocations());
    }

    private static Location[] loadLocations() {
        final Location[] locations = new Location[IslandConfig.Island.MAX_LOCATIONS_ON_ISLAND];
        int it = 0;
        for (int i = 1; i <= IslandConfig.Island.X_SIZE; i++) {
            for (int j = 1; j <= IslandConfig.Island.Y_SIZE; j++) {
                var loc = new Location(i, j);
                locations[it] = loc;

                for (var type : CreatureType.values()) {
                    int initCount = (CreatureConfig.Creature.get(type, CreatureField.INITIAL_COUNT)).intValue();
                    for (int k = 0; k < initCount; k++) {
                        CreatureFactory.createCreature(type, loc);
                    }
                }

                it++;
            }
        }
        return locations;
    }
}