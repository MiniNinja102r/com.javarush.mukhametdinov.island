import config.Config;
import config.values.CreatureConfig;
import config.values.IslandConfig;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Island;
import entity.island.Location;
import repository.CreatureFactory;
import service.SimulationWorker;
import service.StatisticsService;

public final class Launcher {

    public static void main(String[] args) {
        Config.loadAll();

        final Location[] locations = loadLocations();
        Island.initialize(locations);
        loadCreatures(locations);

        final StatisticsService statistics = new StatisticsService();
        final SimulationWorker simulationWorker = new SimulationWorker(statistics);
        simulationWorker.start();
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
}
