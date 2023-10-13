package xxl.core;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class User implements Serializable {
	private static final long serialVersionUID = 202310131017L;
    private String _name;
    private List<String> _spreadSheets; 
    public User(String name){
        _name = name;
        _spreadSheets = new ArrayList<String>();
    }
    public String getName(){
        return _name;
    }
    public List<String> getSpreadSheets(){
        return _spreadSheets;
    }
    public void addSpreadSheet(String s){
        _spreadSheets.add(s);
    }

    
}
