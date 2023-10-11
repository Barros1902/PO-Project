package xxl.core;

public class SUB extends BinaryFunction {
    public SUB(Content arg1, Content arg2){
        super(arg1,arg2);
    }


    public int evalint(){

        return 0;
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
