public class UndoCommand implements Command{
    TurtleReciever r;
    Matrix2 m;
    UndoCommand(TurtleReciever r, Matrix2 m){
        this.r = r;
        this.m = m;
    }
    @Override
    public void execute() {
        r.undoing(m);
    }
    
}
