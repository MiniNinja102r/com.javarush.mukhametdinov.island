package entity.predator;

import entity.Animal;
import entity.CreatureType;
import entity.island.Location;

public class Predator extends Animal {

    public Predator(double weight, Location location, double saturation, CreatureType type) {
        super(weight, location, saturation, type);
    }
}
