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
    /*Colar Esta operac¸ ˜ao insere o conte´udo do cut buffer numa gama da folha de destino. Se o cut buffer estiver vazio, n˜ao ´e realizada
    qualquer operac¸ ˜ao. Se a gama for uma ´unica c´elula, todo o cut buffer deve ser inserido a partir da c´elula especificada, at´e
    ser atingido o limite da folha de c´alculo. Caso contr´ario, se a dimens˜ao do cut buffer for diferente da da gama de destino,
    n˜ao insere nenhum valor. O conte´udo do cut buffer n˜ao ´e alterado pela operac¸ ˜ao. Os objectos inseridos no destino s˜ao
    independentes dos que est˜ao no cut buffer.*/
    //TODO:

}