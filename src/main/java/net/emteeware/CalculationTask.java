package net.emteeware;

import java.util.ArrayList;
import java.util.List;
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
        switch (operation) {
            case ADDITION:
                createNewAddition(resultLimit);
                operationSymbol = "+";
                break;
            case SUBTRACTION:
                createNewSubtraction(resultLimit);
                operationSymbol = "-";
                break;
            case MULTIPLICATION:
                createNewMultiplication(resultLimit);
                operationSymbol = "·";
                break;
            case DIVISION:
                createNewDivision(resultLimit);
                operationSymbol = "÷";
                break;
        }


    }

    private void createNewDivision(int resultLimit) {
        // TODO: Find a better way to get interesting values for the tasks
        boolean recreateFirstParameter = true;
        List<Integer> divisors = new ArrayList<>();
        while(recreateFirstParameter) { // filter primes
            firstParameter = ThreadLocalRandom.current().nextInt(1, (resultLimit + 1));
            divisors = new ArrayList<>();
            for (int i = 1; i <= firstParameter; i++) {
                if (firstParameter % i == 0) {
                    divisors.add(i);
                }
            }
            if(divisors.size() > 2) {
                recreateFirstParameter = false;
            }
        }
        secondParameter = divisors.get(ThreadLocalRandom.current().nextInt(divisors.size()));
        result = firstParameter / secondParameter;
    }

    private void createNewMultiplication(int resultLimit) {
        // TODO: Find a better way to get interesting values for the tasks
        firstParameter = ThreadLocalRandom.current().nextInt(1, ((int)Math.sqrt(resultLimit))+1);
        secondParameter = ThreadLocalRandom.current().nextInt(0, ((int)Math.sqrt(resultLimit))+1);
        result = firstParameter * secondParameter;
    }

    private void createNewSubtraction(int resultLimit) {
        firstParameter = ThreadLocalRandom.current().nextInt(0, resultLimit + 1);
        secondParameter = ThreadLocalRandom.current().nextInt(0, firstParameter + 1);
        result = firstParameter - secondParameter;
    }

    private void createNewAddition(int resultLimit) {
        firstParameter = ThreadLocalRandom.current().nextInt(0, resultLimit + 1);
        secondParameter = ThreadLocalRandom.current().nextInt(0, resultLimit + 1 - firstParameter);
        result = firstParameter + secondParameter;
    }

    @Override
    public String toString() {
        return firstParameter + " " + operationSymbol + " " + secondParameter + " =";
    }
}
