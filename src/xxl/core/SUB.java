package xxl.core;

public class SUB extends BinaryFunction {
    public SUB(Content arg1, Content arg2){
        super(arg1,arg2);
    }


    public int evalint(){

        return super(_arg1.EvalInt()) - arg2.EvalInt();
    }
    
    public String display(){

        return "a";
    }


    @Override
    protected Literals value() {
        return null;
    }

    public String toString(){

        return "a";
    }
}
