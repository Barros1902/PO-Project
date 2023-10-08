package xxl.core;


public class Reference extends Content{
    private Cell _cell;
    Reference(){
    }
    @Override
    public String toString(){
        return "Reference";
    };
    @Override
    public int EvalInt(){
        return 0;
    };
    @Override
    public String evalString(){
        return "";
    };
    @Override
    public String display(){
        return "";
    };
}