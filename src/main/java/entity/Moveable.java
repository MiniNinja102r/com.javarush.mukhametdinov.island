package entity;

import entity.island.Island;
import entity.island.Location;

public interface Moveable {
    void move(Location location, Island island);
}
