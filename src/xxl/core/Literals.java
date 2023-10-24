package xxl.core;


import xxl.core.exception.IntFailedException;
import xxl.core.exception.ArrayCharException;

public abstract class Literals extends Content {

    public abstract String display();
    public abstract String toString();
    public String evalString() throws IntFailedException{
        throw new IntFailedException();
    }

    public int evalInt() throws  ArrayCharException{
        throw new ArrayCharException();
    }

}
