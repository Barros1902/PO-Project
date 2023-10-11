package xxl.core;
import java.util.ArrayList;
import java.util.List;
public class User {
    
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
