package entity.herbivore;

import entity.Animal;
import entity.CreatureType;
import entity.Eatable;
import entity.island.Location;

public class Herbivore extends Animal {

    public Herbivore(double weight, Location location, CreatureType type) {
        super(weight, location, type);
    }

    @Override
    public void eat(Eatable e) {
        //
    }
}
