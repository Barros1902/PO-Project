package xxl.app.exception;

import pt.tecnico.uilib.menus.CommandException;
public class IntFailedException extends CommandException{
    public IntFailedException(Exception e) {
        super("Literal is not a number");
    }
}
