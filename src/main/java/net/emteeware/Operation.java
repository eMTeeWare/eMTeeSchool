package net.emteeware;

/**
 * Created by Merlin Thomas on 2017-01-21.
 *  Copyright 2017 eMTeeWare
 */
public enum Operation {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("·"),
    DIVISION("÷");

    private final String operatorSymbol;

    Operation(String operatorSymbol) {
        this.operatorSymbol = operatorSymbol;
    }

    public String getOperatorSymbol() {
        return operatorSymbol;
    }
}
