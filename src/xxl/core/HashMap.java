package xxl.core;

import java.util.List;

public class HashMap extends Representation {


    private java.util.HashMap<List<Integer>,Cell> _map;
    public HashMap(int width, int height) {
        super(width, height);
        _map = new java.util.HashMap<List<Integer>,Cell>();
    }
    public void setCell(int row, int column, Content content){
        if (row > getHeight() || column > getWidth()){
            throw new IllegalArgumentException("row or column out of bounds");
        }
        List<Integer> key = List.of(row,column);
        Cell cell = new Cell(row,column,content);
        _map.put(key,cell);
    }
    public Cell getCell(int row, int column){
        if (row > getHeight() || column > getWidth()){
            throw new IllegalArgumentException("row or column out of bounds");
        }
        List<Integer> key = List.of(row,column);
        return _map.get(key);
    }




}
