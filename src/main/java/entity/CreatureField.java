package entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum CreatureField {
    WEIGHT("weight"),
    MAX_ON_LOCATION("max_on_location"),
    SPEED("speed"),
    SATURATION("saturation"),

    KILL_WOLF_CHANCE("kill_wolf_chance"),
    KILL_BOA_CONSTRICTOR_CHANCE("kill_boa_constrictor_chance"),
    KILL_FOX_CHANCE("kill_fox_chance"),
    KILL_BEAR_CHANCE("kill_bear_chance"),
    KILL_EAGLE_CHANCE("kill_eagle_chance"),
    KILL_HORSE_CHANCE("kill_horse_chance"),
    KILL_DEER_CHANCE("kill_deer_chance"),
    KILL_RABBIT_CHANCE("kill_rabbit_chance"),
    KILL_MOUSE_CHANCE("kill_mouse_chance"),
    KILL_GOAT_CHANCE("kill_goat_chance"),
    KILL_SHEEP_CHANCE("kill_sheep_chance"),
    KILL_BOAR_CHANCE("kill_boar_chance"),
    KILL_BUFFALO_CHANCE("kill_buffalo_chance"),
    KILL_DUCK_CHANCE("kill_duck_chance"),
    KILL_CATERPILLAR_CHANCE("kill_caterpillar_chance"),
    KILL_PLANT_CHANCE("kill_plant_chance");

    @Getter
    final String configName;
}
