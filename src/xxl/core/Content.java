package xxl.core;

public abstract class Content{
    protected abstract Literals value();
    public int EvalInt(){
        return 0;
    };
    public String evalString(){
        return "";
    };
    public abstract String toString();

}