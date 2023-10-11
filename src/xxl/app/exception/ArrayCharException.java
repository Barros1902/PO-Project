package xxl.app.exception;
import pt.tecnico.uilib.menus.CommandException;


public class ArrayCharException extends CommandException{
    public ArrayCharException(Exception e) {
        super("Literal is not a String");
    }
}
