package xxl.core;

public class NULL extends Literals{
    @Override
    public String evalString(){
        return null;
    }

    @Override
    public int evalInt() {
        return 0;
    }

    @Override
    public String display(){
        return "";
    }
    @Override
    public String toString(){
        return "";
    }
}