/*
 * Speficies a concrete command from the command pattern implements 
 */
public class MoveCommand implements Command {
    TurtleReciever r;
    Matrix2 matrix;
    int direction;
    MoveCommand(TurtleReciever r, int direction, Matrix2 matrix){ // initialize for proper execution
        this.r = r;
        this.direction = direction;
        this.matrix = matrix;
    }
    @Override
    public void execute() { // execute TurtleReciever move() method that does the actual work
        r.move(matrix, direction);
    }
    
}
