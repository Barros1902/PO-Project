package xxl.core;

import xxl.core.exception.IntFailedException;

public class Concat extends RangeFunction {

    Concat(Gama gama) {
        super(gama);
    }
    @Override
    public String evalString() throws IntFailedException{
        if(verifyInputString()){
            throw new IntFailedException();
        }
        StringBuilder concat = new StringBuilder();
        for (Cell cell : getCells()) {
            concat.append(cell.evalString());
        }
        return concat.toString();
    }
    public String toString(){
        //TODO: Change to correct representation
        return "Concat";
    }
}

