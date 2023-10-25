package xxl.core;

import xxl.core.exception.ArrayCharException;

public class Average extends RangeFunction {
    Average(Gama gama) {
        super(gama);
    }

    @Override
    public int evalInt() throws ArrayCharException{
        if (verifyInputInt()) {
            throw new ArrayCharException();
        }
        int sum = 0;
        for (Cell cell : getCells()) {
            sum += cell.evalInt();
        }
        return sum/getCells().size();
    }

    @Override
    public String toString() {
        try {
            return String.valueOf(evalInt()) + "=AVERAGE(" + _gama.toString() + ")";
        } catch (Exception e) {
            return "#VALUE" + "=AVERAGE(" + _gama.toString() + ")";
        }
    }
}

