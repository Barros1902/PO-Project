package xxl.core;

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
            //TODO: add exception can't add strings
        }
    }

    @Override
    protected Literals value() {
        return null;
    }
    @Override
    public String toString(){
        return "=SUB("+getValueArg1().toString()+","+getValueArg1().toString()+")";
    }

}
