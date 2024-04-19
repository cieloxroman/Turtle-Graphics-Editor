/*
 * Is a leaf/child of the TurtleComposite container
 * Creates a matrix that produces the shape of S.
 */
public class S implements Shape2{

    @Override
    public Matrix2 draw(char[][] chr, Sender send, DrawingStrategy strategy) {
        TurtleReciever reciever = new TurtleReciever();
        Matrix2 temp = new Matrix2(chr.length, chr[0].length);
        
        send.setCommand(new TurnCommand(reciever, 90));
        send.execute();
        send.setCommand(new TraceCommand(reciever, 3, strategy, temp));
        send.execute();
        send.setCommand(new TurnCommand(reciever, 180));
        send.execute();
        send.setCommand(new MoveCommand(reciever, 3, temp));
        send.execute();
        send.setCommand(new TurnCommand(reciever, 90));
        send.execute();
        send.setCommand(new TraceCommand(reciever, 2, strategy, temp));
        send.execute();
        send.setCommand(new TurnCommand(reciever, 90));
        send.execute();
        send.setCommand(new TraceCommand(reciever, 3, strategy, temp));
        send.execute();
        send.setCommand(new TurnCommand(reciever, 270));
        send.execute();
        send.setCommand(new TraceCommand(reciever, 2, strategy, temp));
        send.execute();
        send.setCommand(new TurnCommand(reciever, 270));
        send.execute();
        send.setCommand(new TraceCommand(reciever, 3, strategy, temp));
        send.execute();
        return temp;
        
    }
    
}
