package xxl.core;

import xxl.core.exception.ArrayCharException;

public class MUL extends BinaryFunction {
    public MUL(Content arg1, Content arg2){
        super(arg1,arg2);
    }

    @Override
    public int evalInt() throws ArrayCharException {
        try {
            int val1 = getValueArg1().evalInt();
            int val2 = getValueArg2().evalInt();

            return val1*val2;
        } catch(Exception e){
            throw new ArrayCharException();
        }
    }


    @Override
    protected Literals value() {
        return null;
    }


    @Override
    public String toString() {
        String Coords1 = null;
        String Coords2 = null;

        try {
            Coords1 = getValueArg1().CoordsString();
        } catch (Exception e) {
            try {
                Coords1 = String.valueOf(getValueArg1().evalInt());
            } catch (ArrayCharException ex) {
                throw new RuntimeException(ex);
            }
        }

        try {
            Coords2 = getValueArg2().CoordsString();
        } catch (Exception e) {
            try {
                Coords2 = String.valueOf(getValueArg2().evalInt());
            } catch (ArrayCharException ex) {
                throw new RuntimeException(ex);
            }
        }

        try {
            return String.valueOf(evalInt())+"=MUL("+Coords1+","+Coords2+")";
        } catch (Exception e) {
            return "#VALUE"+"=MUL("+Coords1+","+Coords2+")";
        }
    }
}