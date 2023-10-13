package xxl.core;


public class Reference extends Content{
    private Cell _cell;
    public Reference(Cell cell){
        _cell = cell;
    }

    public Cell get_cell() {
        return _cell;
    }
    /**
     * Coords toString
     * */
    @Override
    public String toString() {
        return getValue()+"="+ _cell.getPoint();

    }
    /**
     * return the point
     * */
    public String getPoint(){
        return _cell.getPoint();
    }
    /**
     * return the value of the cell if it gets a Null value return #VALUE
     * */
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
    /**
     * return the value of Num of the cell
     * */
    @Override
    public int EvalInt(){
        return _cell.EvalInt();
    };
    /**
     * return the value of CharArray of the cell
     * */
    @Override
    public String evalString(){
        return _cell.evalString();
    };
}