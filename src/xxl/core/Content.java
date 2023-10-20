package xxl.core;

import java.io.Serializable;

public abstract class Content implements Serializable{
	private static final long serialVersionUID = 202310121846L;
    protected abstract Literals value();
    public abstract int EvalInt();
    public String evalString(){
        return "";
    };
    public abstract String toString();


}