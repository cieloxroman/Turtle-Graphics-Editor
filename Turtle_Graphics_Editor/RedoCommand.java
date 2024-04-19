/*
 * A concrete command of the command pattern implements 
 */
public class RedoCommand implements Command{
    TurtleReciever r;
    Matrix2 m;
    RedoCommand(TurtleReciever r, Matrix2 m){
        this.r = r;
        this.m = m;
    }
    @Override
    public void execute() {
        r.redoing(m); // TurtleReciever from initalization does the heavy lifting aka implementation
        // execute recievers redo method 
    }

}
