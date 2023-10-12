package xxl.app.main;

import java.io.IOException;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import xxl.app.exception.FileOpenFailedException;
import xxl.core.Calculator;
// FIXME import classes
import xxl.core.Spreadsheet;

/**
 * Save to file under current name (if unnamed, query for name).
 */
class DoSave extends Command<Calculator> {

  DoSave(Calculator receiver) {
    super(Label.SAVE, receiver, xxl -> xxl.getSpreadsheet() != null);
    
  }
  
  @Override
  protected final void execute() throws FileOpenFailedException {
	System.out.println("Aqui");
	Spreadsheet sheet = _receiver.getSpreadsheet();
    if( sheet != null && sheet.getFileName() == null){
	  System.out.println("Aqui2");
      addStringField("filename",Message.newSaveAs());
	  System.out.println("Aqui3");
	}
    if(_receiver.getSpreadsheet().getFileName() == null){
      String filename = stringField("filename");
      try {
		_receiver.saveAs(filename);
	  }
	  catch(Exception e)
	  { 
		new FileOpenFailedException(e);
	  }
    }

  }
}
