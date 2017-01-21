package net.emteeware;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Merlin Thomas on 2017-01-21.
 *  Copyright 2017 eMTeeWare
 */
public class CalculationTask {
    private int firstParameter;
    private int secondParameter;
    private String operationSymbol;
    int result;
    CalculationTask(int resultLimit, Operation operation) {
        firstParameter = ThreadLocalRandom.current().nextInt(0, resultLimit + 1);
        switch (operation) {
            case ADDITION:
                createNewAddition(resultLimit);
                operationSymbol = "+";
                break;
        }


    }

    private void createNewAddition(int resultLimit) {
        secondParameter = ThreadLocalRandom.current().nextInt(0, resultLimit + 1 - firstParameter);
        result = firstParameter + secondParameter;
    }

    @Override
    public String toString() {
        return firstParameter + " " + operationSymbol + " " + secondParameter + " =";
    }
}
