package xxl.core;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import xxl.core.exception.*;

// FIXME import classes

/**
 * Class representing a spreadsheet application.
 */
public class Calculator {
  /** The current spreadsheet. */
  private Parser _parser;
  private Spreadsheet _spreadsheet;
  private User _activeUser;
  private ArrayList<User> _users;
  public Calculator() {
    _parser = new Parser(this);
    _spreadsheet = null;
    _activeUser = new User("root");
    _users = new ArrayList<User>();
    _users.add(_activeUser);
  }
  public boolean createUser(String name){
      User user = new User(name);
      _users.add(user);
      return true;
  }
  public void setActiveUser(User user){
    _activeUser=user;
  }
  public User getActiveUser(){
    return _activeUser;
  }
  public Spreadsheet createSpreadSheet(int width, int height ){
    Spreadsheet sheet = new Spreadsheet(width, height, _activeUser);
    _spreadsheet = sheet;
    return sheet;
  }

  // FIXME add more fields and methods if needed

  /**
   * Return the current spreadsheet.
   *
   * @returns the current spreadsheet of this application. This reference can be null.
   */
  public Spreadsheet getSpreadsheet() {
    return _spreadsheet;
  }

  public void setSpreadsheet(Spreadsheet sheet){
    _spreadsheet = sheet;    
  }
  /**
   * Saves the serialized application's state into the file associated to the current network.
   *
   * @throws FileNotFoundException if for some reason the file cannot be created or opened.
   * @throws MissingFileAssociationException if the current network does not have a file.
   * @throws IOException if there is some error while serializing the state of the network to disk.
   */

  public void save() throws FileNotFoundException, MissingFileAssociationException, IOException {
    // FIXME implement serialization method
  }

  /**
   * Saves the serialized application's state into the specified file. The current network is
   * associated to this file.
   *
   * @param filename the name of the file.
   * @throws FileNotFoundException if for some reason the file cannot be created or opened.
   * @throws MissingFileAssociationException if the current network does not have a file.
   * @throws IOException if there is some error while serializing the state of the network to disk.
   */
  public void saveAs(String filename) throws FileNotFoundException, MissingFileAssociationException, IOException {
    // FIXME implement serialization method
  }

  /**
   * @param filename name of the file containing the serialized application's state
   *        to load.
   * @throws UnavailableFileException if the specified file does not exist or there is
   *         an error while processing this file.
   */
  public void load(String filename) throws UnavailableFileException {
    // FIXME implement serialization method
  }



  /**
   * Read text input file and create domain entities.
   *
   * @param filename name of the text input file
   * @throws ImportFileException
   */
/*
  public void importFile(String filename) throws ImportFileException {
    try {
      // FIXME open import file and feed entries to new spreadsheet (in a cycle)
      //       each entry is inserted using insertContent of Spreadsheet. Set new
      // spreadsheet as the active one.
      // ....
    } catch (IOException | UnrecognizedEntryException  FIXME maybe other exceptions  e) {
      throw new ImportFileException(filename, e);
    }

  }
  */
  public void importFile(String filename) throws UnrecognizedEntryException, IOException, ImportFileException, OutOfBoundsException {
    _parser.parseFile(filename);
  }
}
