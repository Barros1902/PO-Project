package xxl.core;

import xxl.core.exception.ArrayCharException;

public class Product extends RangeFunction {
    Product(Gama gama) {
        super(gama);
    }
    @Override
    public int evalInt() throws ArrayCharException {
        if (verifyInputInt()) {
            throw new ArrayCharException();
        }
        int prod = 1;
        for (Cell cell : getCells()) {
            prod *= cell.evalInt();
        }
        return prod;
    }

    @Override
    public String toString() {
        //TODO:See
        return super.toString();
    }
}

