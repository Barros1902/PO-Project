package xxl.core;

import xxl.core.exception.ArrayCharException;
import xxl.core.exception.FunctionException;

public class DIV extends BinaryFunction {
    public DIV(Content arg1, Content arg2){
        super(arg1,arg2);
    }


    public int evalInt() throws ArrayCharException {
        try {
            int val1 = getValueArg1().EvalInt();
            int val2 = getValueArg2().EvalInt();

            return isReference(getValueArg1())*isReference(getValueArg2());
        } catch(Exception e){
            throw new ArrayCharException();
        }
    }
    private int isReference(Content arg) throws FunctionException {
        if(arg.toString().contains("=")){
            return Integer.parseInt(arg.toString().split("=")[0]);
        } else {
            if (arg.EvalInt()==0 && arg.evalString()==null)
                throw new FunctionException();
            return arg.EvalInt();
        }
    }
    private String Transform(Content arg){
        if(arg.toString().contains("=")){
            return String.valueOf(arg.toString().split("=")[1]);
        } else {
            return arg.toString();
        }
    }


    @Override
    protected Literals value() {
        return null;
    }
    @Override
    public String toString(){
        try {
            return String.valueOf(evalInt())+"=DIV("+Transform(getValueArg1())+","+Transform(getValueArg2())+")";
        } catch (Exception e) {
            return "#VALUE"+"=DIV("+Transform(getValueArg1())+","+Transform(getValueArg2())+")";
        }

    }
}