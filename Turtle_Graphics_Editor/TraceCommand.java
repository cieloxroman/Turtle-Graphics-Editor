/*
 * Concrete command from command pattern that uses TurtleReciever to execute functionality
 */
public class TraceCommand implements Command{
    TurtleReciever r;
    double distance;
    DrawingStrategy strategy;
    Matrix2 matrix;
    TraceCommand(TurtleReciever r, double distance, DrawingStrategy strategy, Matrix2 matrix){
        this.r = r;
        this.distance = distance;
        this.strategy = strategy;
        this.matrix = matrix;
    }
    @Override
    public void execute() {
        r.trace(matrix, distance, strategy); // calls reciever trace() method to execute that commands functionality
    }
    
}
