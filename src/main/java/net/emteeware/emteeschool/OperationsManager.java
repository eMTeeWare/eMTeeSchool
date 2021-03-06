package net.emteeware.emteeschool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Merlin Thomas on 2017-01-21.
 *  Copyright 2017 eMTeeWare
 */
class OperationsManager {
    private Map<Operation, Boolean> enabledOperations = initEnabledOperations();

    private static Map<Operation, Boolean> initEnabledOperations() {
        Map<Operation, Boolean> initialEnabledOperationsMap = new HashMap<>();
        initialEnabledOperationsMap.put(Operation.ADDITION, true);
        initialEnabledOperationsMap.put(Operation.SUBTRACTION, false);
        initialEnabledOperationsMap.put(Operation.MULTIPLICATION, false);
        initialEnabledOperationsMap.put(Operation.DIVISION, false);

        return initialEnabledOperationsMap;
    }

    void enable(Operation op) {
        setOperationState(op, true);
    }

    void disable(Operation op) {
        setOperationState(op, false);
    }

    private void setOperationState(Operation op, boolean state) {
        switch (op) {
            case ADDITION:
                enabledOperations.put(Operation.ADDITION, state);
                break;
            case DIVISION:
                enabledOperations.put(Operation.DIVISION, state);
                break;
            case MULTIPLICATION:
                enabledOperations.put(Operation.MULTIPLICATION, state);
                break;
            case SUBTRACTION:
                enabledOperations.put(Operation.SUBTRACTION, state);
                break;
            default:
                // In case this case is reached, a new operation type has not been implemented correctly
                throw new UnsupportedOperationException(op.name());
        }
    }

    Operation getNextOperation() {
        List<Operation> availableOperations = new ArrayList<>();
        for(Operation op: Operation.values()){
            if(enabledOperations.get(op)) {
                availableOperations.add(op);
            }
        }
        return availableOperations.get(ThreadLocalRandom.current().nextInt(availableOperations.size()));
    }
}
