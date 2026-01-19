package entity.island;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public final class Island {

    @Getter
    final Location[] locations;

    private static Island instance;

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

    public Location getLocation(int x, int y) {
        for (Location loc : locations) {
            if (loc.getX() == x && loc.getY() == y) {
                return loc;
            }
        }

        return null;
    }
}
