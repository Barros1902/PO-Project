package xxl.core;

public abstract class Content{
    private Cell _cell;
    Content(){
    }
    public String toString(){
        return "";
    }
    public void setCell(Cell cell){
        _cell = cell;
    }
    public int EvalInt(){
        return 0;
    };
    public String evalString(){
        return "";
    };
    public String display(){
        return "";
    };

}