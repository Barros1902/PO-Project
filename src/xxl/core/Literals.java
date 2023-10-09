package xxl.core;

public abstract class Literals extends Content {

    public abstract int evalInt();
    public abstract String display();
    public abstract String toString();
    public abstract String evalString();

    @Override
    protected Literals value() {
        if (evalString()==null){
            return new Num(evalInt());
        }
        else{
            return new CharArray(evalString());
        }
    }
}
