package xxl.core;

import javax.swing.text.AbstractDocument.Content;

import xxl.core.exception.ArrayCharException;

public class SUB extends BinaryFunction {
    public SUB(Content arg1, Content arg2){
        super(arg1,arg2);
    }
    public int evalInt() throws ArrayCharException {
        try {
            int val1 = getValueArg1().EvalInt();
            int val2 = getValueArg2().EvalInt();

            return val1-val2;
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
        try {
            return String.valueOf(evalInt())+"=SUB("+String.valueOf(getValueArg1().EvalInt())+","+String.valueOf(getValueArg2().EvalInt())+")";
        } catch (Exception e) {
            return "#VALUE"+"=SUB("+String.valueOf(getValueArg1().EvalInt())+","+String.valueOf(getValueArg2().EvalInt())+")";
        }
    }
}
