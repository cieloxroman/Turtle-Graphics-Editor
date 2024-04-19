/*
 * Is a leaf/child of the TurtleComposite container
 * Creates a matrix that produces the shape of "0".
 */
public class Zero implements Shape2{

    @Override
    public Matrix2 draw(char[][] chr, Sender send, DrawingStrategy strategy) {
        TurtleReciever reciever = new TurtleReciever();
        Matrix2 temp = new Matrix2(chr.length, chr[0].length);
         
        // Use command pattern to implememnt a "0" into matrix temp using TurtleReciever
        send.setCommand(new TraceCommand(reciever, chr[0].length, strategy, temp));
        send.execute();
        send.setCommand(new TurnCommand(reciever, 90));
        send.execute();
        send.setCommand(new TraceCommand(reciever, chr.length-2, strategy, temp));
        send.execute();
        send.setCommand(new TurnCommand(reciever, 90));
        send.execute();
        send.setCommand(new TraceCommand(reciever, chr[0].length, strategy, temp));
        send.execute();
        send.setCommand(new TurnCommand(reciever, 90));
        send.execute();
        send.setCommand(new TraceCommand(reciever, chr.length-2, strategy, temp));
        send.execute();
        return temp;
    }
    
}
