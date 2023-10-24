package xxl.core;

import xxl.core.exception.IntFailedException;

public class Coalesce extends RangeFunction {
    Coalesce(Gama gama) {
        super(gama);
    }
    public String evalString() throws IntFailedException {
        if(verifyInputInt()){
            return "";
        }
        for (Cell cell : getCells()) {
            try{
                return cell.evalString();
            } catch (Exception e){
                //Do nothing
            }

        }
        return "";
    }
    public String toString(){
        //TODO: Change to correct representation
        return "Coalesce";
    }

}

