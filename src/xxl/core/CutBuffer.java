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
        else if (_instance._content.size()==1){
            SingleCell(gama);
        }
        else{
            MultipleCell(gama);
        }
    }
    private static void SingleCell(Gama gama) throws OutOfBoundsException, InvalidCellRangeException {
        Spreadsheet spreadsheet = gama.getSpreadsheet();
        if (spreadsheet == null)
            return;
        try{
            if(spreadsheet.enoughSpace(gama.getCells().get(0),_instance._content.size())){
                for(int i=0;i<_instance._content.size();i++){
                    spreadsheet.getCell(gama.getBeginRow()+i,gama.getBeginColumn()).setContent(_instance._content.get(i).getContent());
                }

            }
            else{
                return;
            }
        } catch (Exception e){
            return;
        }
        return;

    }
    private static void MultipleCell(Gama gama) throws OutOfBoundsException, InvalidCellRangeException {
        try{
            if(gama.getContents().size()!=_instance._content.size())
                return;
            for(int i=0;i<gama.getContents().size();i++){
                gama.getCells().get(i).setContent(_instance._content.get(i).getContent());
            }
        } catch (Exception e){
            return;
        }
        return;
    }

}