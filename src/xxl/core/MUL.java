package xxl.core;

import xxl.core.exception.ArrayCharException;

public class MUL extends BinaryFunction {
    public MUL(Content arg1, Content arg2){
        super(arg1,arg2);
    }
    /**
     * get the values of the arguments and return the result of the function
     * @return the result of the function
     * */
    public int evalInt() throws ArrayCharException {
        try {
            int val1 = getValueArg1().EvalInt();
            int val2 = getValueArg2().EvalInt();

            return isReference(getValueArg1())*isReference(getValueArg2());
        } catch(Exception e){
            throw new ArrayCharException();
        }
    }
    /**
     * If the arg is a reference, return the value of the reference, else return the value of the arg
     * */
    private int isReference(Content arg){
        if(arg.toString().contains("=")){
            return Integer.parseInt(arg.toString().split("=")[0]);
        } else {
            if (arg.EvalInt()==0 && arg.evalString()==null)
                return 1;
            return arg.EvalInt();
        }
    }
    /**
     * Transform to the right format the arg
     * */
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
    /**
     * Representation to the terminal of the MUL function
     * */
    @Override
    public String toString(){
        try {
            return String.valueOf(evalInt())+"=MUL("+Transform(getValueArg1())+","+Transform(getValueArg2())+")";
        } catch (Exception e) {
            return "#VALUE"+"=MUL("+Transform(getValueArg1())+","+Transform(getValueArg2())+")";
        }

    }
}