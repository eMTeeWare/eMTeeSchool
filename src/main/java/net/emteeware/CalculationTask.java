package net.emteeware;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Merlin Thomas on 2017-01-21.
 *  Copyright 2017 eMTeeWare
 */
public class CalculationTask {
    private int firstParameter;
    private int secondParameter;
    int result;
    CalculationTask(int resultLimit, Operation nextOperation) {
        firstParameter = ThreadLocalRandom.current().nextInt(0, resultLimit + 1);
        secondParameter = ThreadLocalRandom.current().nextInt(0, resultLimit + 1 - firstParameter);
        result = firstParameter + secondParameter;
    }

    @Override
    public String toString() {
        return firstParameter + " + " + secondParameter + " =";
    }
}
