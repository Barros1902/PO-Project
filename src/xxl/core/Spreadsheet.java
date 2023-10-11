package xxl.core;

import java.util.ArrayList;

import java.util.List;
import java.io.Serial;
import java.io.Serializable;

import xxl.core.exception.OutOfBoundsException;
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
    _user = new ArrayList<User>();
    _user.add(user);
    _representation = new HashMap(width, height);
  }
  public void SetName(String name){
    _name=name;
  }
  public String GetName(){
    return _name;
  }
  private void outOfBounds(int row, int column) throws OutOfBoundsException {
      if (_representation.outOfBounds(row, column)) {
            throw new OutOfBoundsException();
        }
    }
  public Cell getCell(int row, int column) throws OutOfBoundsException{
    outOfBounds(row, column);
    return _representation.getCell(row, column);
  }
  public void addContent(int row, int column, Content content) throws OutOfBoundsException{ // Isto adiciona e muda content
    outOfBounds(row, column);
    _representation.insertContent(row, column, content);
  }
  public void removeContent(int row, int column) throws OutOfBoundsException{
    outOfBounds(row, column);
    _representation.removeContent(row, column);
  }

  /**
   * Insert specified content in specified address.
   *
   * @param row the row of the cell to change 
   * param column the column of the cell to change
   * @param content the content to insert
   *        in the specified cell.
   */
  public void insertContent(int row, int column, Content content) throws UnrecognizedEntryException /* FIXME maybe add exceptions */ {
    _representation.insertContent(row, column, content);
  }
}
