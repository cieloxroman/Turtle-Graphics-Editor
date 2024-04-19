/*
 * Is a concrete command from command pattern that uses Reciever to execute functionality
 */
public class TurnCommand implements Command{
    TurtleReciever r;
    int degree;
    TurnCommand(TurtleReciever r, int degree){
        this.r = r;
        this.degree = degree;
    }
    @Override
    public void execute() {
        r.turn(degree); // Executing reciever turn() method which does the commands turning functionality
    }
    
}
