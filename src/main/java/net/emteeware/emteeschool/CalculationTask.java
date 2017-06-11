package net.emteeware.emteeschool;

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
                operationSymbol = Operation.ADDITION.getOperatorSymbol();
                break;
            case SUBTRACTION:
                createNewSubtraction(resultLimit);
                operationSymbol = Operation.SUBTRACTION.getOperatorSymbol();
                break;
            case MULTIPLICATION:
                createNewMultiplication(resultLimit);
                operationSymbol = Operation.MULTIPLICATION.getOperatorSymbol();
                break;
            case DIVISION:
                createNewDivision(resultLimit);
                operationSymbol = Operation.DIVISION.getOperatorSymbol();
                break;
            default:
                // In case this case is reached, a new operation type has not been implemented correctly
                throw new UnsupportedOperationException(operation.name());
        }


    }

    private void createNewDivision(int resultLimit) {
        boolean recreateFirstParameter = true;
        List<Integer> divisors = new ArrayList<>();
        while(recreateFirstParameter) { // filter primes
            firstParameter = ThreadLocalRandom.current().nextInt(1, (resultLimit + 1));
            divisors = new ArrayList<>();
            divisors.add(1);
            for (int i = 2; i <= firstParameter; i++) {
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
        firstParameter = ThreadLocalRandom.current().nextInt(1, (new Double((Math.sqrt(resultLimit))+1).intValue()));
        secondParameter = ThreadLocalRandom.current().nextInt(0, (new Double((Math.sqrt(resultLimit))+1).intValue()));
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
