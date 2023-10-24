package xxl.core;

import xxl.core.exception.ArrayCharException;
import xxl.core.exception.IntFailedException;

import java.util.List;

public class RangeFunction extends Function{
    Gama _gama;
    RangeFunction(Gama gama){
        _gama = gama;
    }

    @Override
    protected Literals value() {
        return null;
    }

    @Override
    public int evalInt() throws ArrayCharException {
        throw new ArrayCharException();
    }

    @Override
    public String evalString() throws IntFailedException {
        throw new IntFailedException();
    }

    @Override
    public String toString() {
        return null;
    }

    protected List<Cell> getCells(){
        try{
            return _gama.getCells();
        } catch (Exception e){
            return null;
        }
    }
    public boolean verifyInputBasic(){
        if(getCells()==null){
            return true;
        }
        return getCells().isEmpty();
    }
    public boolean verifyInputInt() {
        if (verifyInputBasic()) {
            return true;
        }
        for (Cell cell : getCells()) {
            try {
                cell.evalInt();
            } catch (ArrayCharException e) {
                return true;
            }
        }
        return false;
    }
    public boolean verifyInputString(){
        if(verifyInputBasic()){
            return false;
        }
        for (Cell cell : getCells()) {
            try {
                cell.evalString();
            } catch (IntFailedException e) {
                return false;
            }
        }
        return true;
    }
}
