package xxl.core;

import xxl.core.exception.ArrayCharException;
import xxl.core.exception.CoordsException;
import xxl.core.exception.IntFailedException;

import java.io.Serializable;

public abstract class Content implements Serializable{
	private static final long serialVersionUID = 202310121846L;
    protected abstract Literals value();
    public abstract int evalInt() throws ArrayCharException;
    public abstract String evalString() throws IntFailedException;
    public abstract String toString();

    public abstract Content getContent();

    public String CoordsString() throws CoordsException {
        throw new CoordsException();
    }
}