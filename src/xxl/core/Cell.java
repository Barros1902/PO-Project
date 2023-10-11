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
    public Content getContent(){
        return _content;
    }
    public String toString(){
        return _content.toString();
    }

    public void write(){

    }
}
