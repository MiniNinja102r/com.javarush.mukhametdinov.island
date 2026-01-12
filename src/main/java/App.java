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

public class App {

    public static void main(String[] args) {
        Config.loadAll();

//        Scheduler.startScheduleTask();

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

        Animal animal = AnimalFactory.createAnimal(AnimalType.WOLF);
        System.out.println(animal);

        Wolf wolf = (Wolf) animal;
        System.out.println(wolf);

    }
}
