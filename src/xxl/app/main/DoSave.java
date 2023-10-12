package xxl.app.main;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import xxl.app.exception.FileOpenFailedException;
import xxl.core.Calculator;
// FIXME import classes

/**
 * Save to file under current name (if unnamed, query for name).
 */
class DoSave extends Command<Calculator> {

  DoSave(Calculator receiver) {
    super(Label.SAVE, receiver, xxl -> xxl.getSpreadsheet() != null);
    if(_receiver.getSpreadsheet() != null && _receiver.getSpreadsheet().getFileName() != null)
      addStringField("filename",Message.newSaveAs());
  }
  
  @Override
  protected final void execute() throws FileOpenFailedException {
    /*
    if(_receiver.getSpreadsheet() == null){
      String filename = stringField("filename");
      _receiver.saveAs(filename);

    }*/

  }
}
