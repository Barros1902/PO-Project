package xxl.app.main;

import java.io.Serializable;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.core.Calculator;


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
    int width = integerField("width");
    int height = integerField("height");
    _receiver.createSpreadSheet(width, height);


  }
}
