package xxl.core;

public class Num extends Literals{
    private final int _value;
    public Num(int value){
        _value = value;
    }

    @Override
    protected Literals value() {
        return null;
    }

    @Override
    public int evalInt(){
        return _value;
    }
    /**
     * @return the value of Num of the cell
     * */
    @Override
    public String display(){
        return Integer.toString(_value);
    }
    /**
     * @return the representation to the terminal
     * */
    @Override
    public String toString(){
        return Integer.toString(_value);
    }
}