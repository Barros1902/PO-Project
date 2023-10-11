package xxl.core;

import java.util.List;
public class User {
    
    private String _name;
    private List<SpreadSheet> _spreadSheets;
    public User(String name){
        _name = name;
        _spreadSheets = new ArrayList<SpreadSheet>();
    }
    public String getName(){
        return _name;
    }
    public List<SpreadSheet> getSpreadSheets(){
        return _spreadSheets;
    }
    public void addSpreadSheet(SpreadSheet s){
        _spreadSheets.add(s);
    }

    
}
