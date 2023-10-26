package xxl.core;

import xxl.app.exception.InvalidCellRangeException;
import xxl.core.exception.OutOfBoundsException;

import java.util.List;
public class CutBuffer { //Singleton
    private static CutBuffer _instance;
    private List<Content> _content;

    private CutBuffer(List<Content> content){
        _content = content;
    }
    public static CutBuffer copy(Gama gama) throws OutOfBoundsException, InvalidCellRangeException {
        if(_instance == null)
            _instance = new CutBuffer(gama.getContents());
        else{
            _instance._content = gama.getContents();
        }
        return _instance;
    }
    public static CutBuffer cut(Gama gama) throws OutOfBoundsException, InvalidCellRangeException {
        if(_instance == null)
            _instance = new CutBuffer(gama.getContents());
        else{
            _instance._content = gama.getContents();
        }
        gama.clear();
        return _instance;
    }
    public static void paste(Gama gama) throws OutOfBoundsException, InvalidCellRangeException {
        if(_instance == null)
            return;
        else if (gama.getCells().size()==1){
            SingleCell(gama);
        }
        else{
            MultipleCell(gama);
        }
    }
    private static void SingleCell(Gama gama) throws OutOfBoundsException, InvalidCellRangeException {
        if (!gama.getSpreadsheet().enoughSpace(gama.getCellsNoCopy().get(0), _instance._content.size()))
            return;
        if(gama.isRow()){
            for (int i = 0; i < _instance._content.size(); i++) {
                gama.getSpreadsheet().getCell(gama.getBeginRow()+i,gama.getBeginColumn()).setContent(_instance._content.get(i));
            }
        } else {
            for (int i = 0; i < _instance._content.size(); i++) {
                gama.getSpreadsheet().getCell(gama.getBeginRow(),gama.getBeginColumn()+i).setContent(_instance._content.get(i));
            }
        }
    }
    private static void MultipleCell(Gama gama) throws OutOfBoundsException, InvalidCellRangeException {
        for (int i = 0; i < _instance._content.size(); i++) {
            gama.getCellsNoCopy().get(i).setContent(_instance._content.get(i));
        }
    }

}