package xxl.core;


public class Reference extends Content{
    private Cell _cell;
    public Reference(Cell cell){
        _cell = cell;
    }

    public Cell get_cell() {
        return _cell;
    }

    @Override
    public String toString(){
        return _cell.toString();
    };

    @Override
    protected Literals value() {
        return null;
    }

    @Override
    public int EvalInt(){
        return _cell.EvalInt();
    };
    @Override
    public String evalString(){
        return _cell.evalString();
    };
}