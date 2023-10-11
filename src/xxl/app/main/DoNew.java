package xxl.app.main;

import java.io.Serializable;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.core.Calculator;
import xxl.core.Spreadsheet; //Needed?
import xxl.core.User; //Needed?

/**
 * Open a new file.
 */
class DoNew extends Command<Calculator> {

  DoNew(Calculator receiver) {
    super(Label.NEW, receiver);
  }
  
  @Override
  protected final void execute() throws CommandException {
    // FIXME implement command
    addIntegerField("width" , Message.columns());
    addIntegerField("height" , Message.lines());
    addStringField("name", "Insira o nome da folha"); // TODO Remove name
    int width = integerField("width");
    int height = integerField("height");
    String name = stringField("name");
    User user = _receiver.getActiveUser();
    Spreadsheet Folha = new Spreadsheet(width, height, name, user);
    user.addSpreadSheet(Folha);


  }
}
