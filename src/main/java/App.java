import config.Config;
import config.list.IslandConfig;
import config.list.SchedulerConfig;
import entity.island.Island;
import entity.island.Location;
import service.scheduler.Scheduler;

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
    }
}
