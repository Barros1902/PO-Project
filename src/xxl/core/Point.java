package xxl.core;

public class Point {
    
    private int _row;
    private int _column;

    public Point(int row, int column){
        _row = row;
        _column = column;
    }
    public int getRow(){
        return _row;
    }
    public int getColumn(){
        return _column;
    }
}
