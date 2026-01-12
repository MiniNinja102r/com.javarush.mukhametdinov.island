package entity.island;

import entity.Animal;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public final class Location {

    final int x;
    final int y;
    final Map<Animal, Integer> animals = new HashMap<>();

    public Map<Animal, Integer> getAnimals() {
        return Collections.unmodifiableMap(animals);
    }

    public void addAnimal(Animal animal) {
        this.animals.merge(animal, 1, Integer::sum);
    }
}
