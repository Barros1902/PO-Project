package xxl.core;


public class Reference extends Content{
    private Cell _cell;
    Reference(Cell cell){
        _cell = cell;
    }

    public Cell get_cell() {
        return _cell;
    }

    @Override
    public String toString(){
        return _cell.getContent().toString();
    };

    @Override
    protected Literals value() {
        return null;
    }

    @Override
    public int EvalInt(){
        return _cell.getContent().EvalInt();
    };
    @Override
    public String evalString(){
        return _cell.getContent().evalString();
    };
}