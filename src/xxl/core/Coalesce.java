package xxl.core;

import xxl.core.exception.IntFailedException;

public class Coalesce extends RangeFunction {
    Coalesce(Gama gama) {
        super(gama);
    }
    public String evalString() throws IntFailedException {
        String result = "";
        for (Cell cell : getCells()) {
            try{
                if (verifyIsNull(cell)){
                    continue;
                }
                result= cell.evalString();
                break;
            } catch (Exception e){
                //Do nothing
            }

        }
        return result;
    }
    public boolean verifyIsNull(Cell cell){
        boolean result = false;
        try {
            cell.getContent().evalString();
            cell.getContent().evalInt();
            result = true;
        } catch (Exception e) {
            //Do nothing
        }

        return result;
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

