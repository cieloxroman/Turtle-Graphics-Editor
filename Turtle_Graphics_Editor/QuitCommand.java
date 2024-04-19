/*
 * Is a concrete command of the command pattern implemented
 * Simply quits the application
 */
public class QuitCommand implements Command{
    TurtleReciever r;
    QuitCommand(TurtleReciever r){
        this.r = r;
    }
    @Override
    public void execute() { // execute the recievers quit() method
        r.quit();
    }
    
}
