package entity.island;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Random;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public final class Island {

    final Location[] locations;

    private static Island instance;
    private static final Random random = new Random();

    public static void initialize(Location[] locations) {
        if (instance == null)
            instance = new Island(locations);
        else
            throw new IllegalStateException("Island already initialized.");
    }

    public static synchronized Island getInstance() {
        if (instance == null)
            throw new IllegalStateException("Island not initialized.");
        else return instance;
    }

    public Location getRandomLocation() {
        int i = random.nextInt(locations.length);
        return locations[i];
    }
}
