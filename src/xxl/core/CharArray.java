package xxl.core;

public class CharArray extends Literals{
    private final String _value;
    public CharArray(String value){
        _value = value;
    }
    @Override
    public int evalInt(){
        //TODO: throw exception
        return 0;
    }
    @Override
    public String display(){
        return _value;
    }
    @Override
    public String toString(){
        return "'"+_value;
    }
    @Override
    public String evalString(){
        //TODO: throw exception
        return _value;
    }
}