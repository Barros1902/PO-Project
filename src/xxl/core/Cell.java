package xxl.core;

import xxl.core.exception.ArrayCharException;
import xxl.core.exception.IntFailedException;

import java.io.Serializable;

public class Cell implements Serializable {
	private static final long serialVersionUID = 202310121845L;
    private Point _point;
    private Content _content;
    public Cell(int row, int column, Content content){
        _point = new Point(row,column);
        _content = content;
    }

    protected void setContent(Content content){
        _content = content;
    }
    public Content getContent(){
        return _content;
    }
    public String getPoint(){
        return _point.toString();
    }
    public int evalInt() throws ArrayCharException {
        return _content.evalInt();
    };
    public String evalString() throws IntFailedException {
        return _content.evalString();
    };
    public String toString(){
        return String.valueOf(_point.getRow())+";"+String.valueOf(_point.getColumn())+"|"+_content.toString();
    }

    public void write(){

    }
}
