package xxl.core;

public class Cell {
    private Point _point;
    private Content _content;
    public Cell(int row, int column, Content content){
        _point = new Point(row,column);
        _content = content;
    }

    protected void setContent(Content content){
        _content = content;
    }
    public int EvalInt(){
        return _content.EvalInt();
    };
    public String evalString(){
        return _content.evalString();
    };
    public String toString(){
        return String.valueOf(_point.getRow())+";"+String.valueOf(_point.getColumn());
    }

    public void write(){

    }
}
