package xxl.core;


import xxl.core.exception.ArrayCharException;
import xxl.core.exception.IntFailedException;

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
    @Override
    public String CoordsString() {
        return _cell.getPoint();
    }
    /**
     * return the value of the cell if it gets a Null value return #VALUE
     * */
    private String getValue(){
        try{
            if (_cell.getContent().evalInt()==0 && _cell.getContent().evalString()==null)
                return "#VALUE";
        } catch (Exception e){
            return _cell.getContent().toString();
        }
        return _cell.getContent().toString();
    }
    public Content getContent(){
        return _cell.getContent();
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
    public int evalInt() throws ArrayCharException {
        return _cell.evalInt();
    };
    /**
     * return the value of CharArray of the cell
     * */
    @Override
    public String evalString() throws IntFailedException {
        return _cell.evalString();
    };
}