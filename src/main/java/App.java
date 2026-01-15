import config.Config;
import config.list.CreatureConfig;
import config.list.IslandConfig;
import entity.Creature;
import entity.CreatureField;
import entity.CreatureType;
import entity.island.Island;
import entity.island.Location;
import service.scheduler.Scheduler;
import repository.CreatureFactory;

import java.util.Arrays;
import java.util.Map;

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
            CreatureFactory.createCreature(CreatureType.WOLF);
            CreatureFactory.createCreature(CreatureType.HORSE);
        }

        for (Location location : Island.getInstance().getLocations()) {
            Map<Creature, Integer> animals = location.getCreatures();
            for (var entry : animals.entrySet()) {
                System.out.printf("%s:%d, %n", entry.getKey(), entry.getValue());
            }
        }

        System.out.println("-".repeat(100));
        for (var type : CreatureType.values()) {
            System.out.println(type.getEmoji() + ": " + CreatureConfig.Creature.get(type, CreatureField.KILL_FOX_CHANCE));
        }
    }
}

//todo:
// автоматическое заполнение локации животными при создании локации.
// прочитать CQRS паттерн
// ReentrantLock на Location, способ синхронизации
// В service можно использовать Worker
