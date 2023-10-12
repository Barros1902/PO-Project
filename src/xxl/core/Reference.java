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
    public String toString() {
        return getValue()+"="+ _cell.getPoint();

    }
    public String getPoint(){
        return _cell.getPoint();
    }
    private String getValue(){
        if(_cell.getContent().evalString()==null){
            return "#VALUE";
        }
        else{
            return _cell.getContent().toString();
        }
    }

    protected String valueString() {
        return _cell.getContent().toString();
    }

    @Override
    protected Literals value() {
        return (Literals) _cell.getContent();
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