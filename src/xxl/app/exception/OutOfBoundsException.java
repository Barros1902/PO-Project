package xxl.app.exception;
import pt.tecnico.uilib.menus.CommandException;
public class OutOfBoundsException extends CommandException{
    public OutOfBoundsException(Exception e) {
        super("Out of Bounds");
    }
}
