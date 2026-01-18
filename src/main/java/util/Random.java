package util;

import lombok.experimental.UtilityClass;

import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public final class Random {

    public static ThreadLocalRandom getRandom() {
        return ThreadLocalRandom.current();
    }
}
