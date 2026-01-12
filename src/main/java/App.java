import config.Config;
import config.list.IslandConfig;
import config.list.SchedulerConfig;
import entity.Animal;
import entity.AnimalType;
import entity.island.Island;
import entity.island.Location;
import entity.predator.Wolf;
import service.scheduler.Scheduler;
import util.AnimalFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        Config.loadAll();

        final Location[] locations = new Location[IslandConfig.Island.MAX_LOCATIONS_ON_ISLAND];
        int it = 0;
        for (int i = 1; i <= IslandConfig.Island.X_SIZE; i++) {
            for (int j = 1; j <= IslandConfig.Island.Y_SIZE; j++) {
                var loc = new Location(i, j);
                locations[it] = loc;
                it++;
            }
        }
        System.out.println(Arrays.toString(locations));

        Island.initialize(locations);
        Scheduler.startScheduleTask();

        for (int i = 0; i < 12; i++) {
            AnimalFactory.createAnimal(AnimalType.WOLF);
            AnimalFactory.createAnimal(AnimalType.HORSE);
        }

        System.out.println(Arrays.toString(locations));
    }
}
