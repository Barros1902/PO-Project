package xxl.core;

import java.util.List;

public class HashMap extends Representation {


    private java.util.HashMap<List<Integer>,Cell> _map;
    public HashMap(int width, int height) {
        super(width, height);
        _map = new java.util.HashMap<List<Integer>,Cell>();
    }
    private void setCell(int row, int column, Content content){
        List<Integer> key = List.of(row,column);
        Cell cell = new Cell(row,column,content);
        _map.put(key,cell);
    }
    private void changeContentCell(Cell cell, Content content){
        cell.setContent(content);
    }
    private Cell getCell(int row, int column){
        if (row > getHeight() || column > getWidth()) {
            throw new IllegalArgumentException("row or column out of bounds");
        }
        List<Integer> key = List.of(row,column);
        return _map.get(key);
    }
    @Override
    public void insertContent(int row, int column, Content content) throws UnrecognizedEntryException {
        if (getCell(row,column) != null) {
            changeContentCell(getCell(row,column),content);
        }else{
            setCell(row,column,content);
        }
    }
    @Override
    public void removeContent(int row, int column) throws UnrecognizedEntryException {
        if (getCell(row,column) != null) {
            changeContentCell(getCell(row,column),new NULL());
        }else{
            throw new UnrecognizedEntryException("Cell does not exist");
        }
    }

}
