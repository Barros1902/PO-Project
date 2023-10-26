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
    @Override
    public Content getContent() {
        return new Coalesce(_gama.copy());
    }
    public String toString(){
        try {
            return evalString() + "=COALESCE(" + _gama.toString() + ")";
        } catch (Exception e) {
            return "#VALUE" + "=COALESCE(" + _gama.toString() + ")";
        }
    }

}

