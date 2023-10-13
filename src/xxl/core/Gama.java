package xxl.core;

import xxl.core.exception.OutOfBoundsException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Gama implements Serializable{
	private static final long serialVersionUID = 202310131019L;

    private int BeginRow;
    private int BeginColumn;
    private int EndRow;
    private int EndColumn;
    private Spreadsheet _spreadsheet;
    public Gama(int beginRow, int beginColumn, int endRow, int endColumn, Spreadsheet spreadsheet){
        BeginRow = beginRow;
        BeginColumn = beginColumn;
        EndRow = endRow;
        EndColumn = endColumn;
        _spreadsheet = spreadsheet;
    }
    public String toString(){
        return BeginRow+";"+"BeginColumn"+":"+EndRow+";"+EndColumn;
    }
    public List<Cell> getCells() throws OutOfBoundsException {
        List<Cell> cells = new ArrayList<Cell>();
        for (int i = BeginRow; i <= EndRow; i++) {
            for (int j = BeginColumn; j <= EndColumn; j++) {
                cells.add(_spreadsheet.getCell(i,j));
            }
        }
        return cells;

    }
    
}
