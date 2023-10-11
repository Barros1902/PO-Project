package xxl.core;

import java.util.ArrayList;

import java.util.List;
import java.io.Serial;
import java.io.Serializable;

import xxl.core.exception.UnrecognizedEntryException;

/**
 * Class representing a spreadsheet.
 */
public class Spreadsheet implements Serializable {
  @Serial
  private static final long serialVersionUID = 202308312359L;
  private String _name;
  private List<User> _user;
  private final Representation _representation;
  public Spreadsheet(int width, int height, User user){
    _user= new ArrayList<String>();
    _user.add(user);
    _representation = new HashMap(width, height);
  }
  public SetName(String name){
    _name=name;
  }
  public Representation getRepresentation(){
      return _representation;
  }

  /**
   * Insert specified content in specified address.
   *
   * @param row the row of the cell to change 
   * param column the column of the cell to change
   * @param contentSpecification the specification in a string format of the content to put
   *        in the specified cell.
   */
  public void insertContent(int row, int column, String contentSpecification) throws UnrecognizedEntryException /* FIXME maybe add exceptions */ {

  }
}
