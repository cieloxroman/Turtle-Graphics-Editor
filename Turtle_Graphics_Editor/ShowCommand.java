/*
 * Is a concrete command of command pattern which uses a reciever method to print out matrix
 */
public class ShowCommand implements Command {
    TurtleReciever r;
    Matrix2 matrix;
    ShowCommand(TurtleReciever r, Matrix2 matrix){
        this.r = r;
        this.matrix = matrix;
    }
    @Override
    public void execute() { // use/call of reciever show() method 
        r.show(matrix);
    }
    
}
