package xxl.core;

public abstract class Representation {
    private final int _width;
    private final int _height;

    public Representation(int width, int height){
        _width = width;
        _height = height;
    }
    public int getWidth(){
        return _width;
    }
    public int getHeight(){
        return _height;
    }
    public Boolean outOfBounds(int row, int column){
        return row > _width || column > _height;
    }
    public abstract void insertContent(int row, int column, Content content);
    public abstract void removeContent(int row, int column);


    public abstract Cell getCell(int row, int column);
}
