/*
 * Is a leaf/child of the TurtleComposite container
 * Creates a matrix that produces the shape of " ".
 */
public class Space implements Shape2{

    @Override
    public Matrix2 draw(char[][] chr, Sender send, DrawingStrategy strategy) {
        //Matrix2 temp = new Matrix2(chr); //simply add no spacing
        Matrix2 temp = new Matrix2(chr.length, chr[0].length);
        return temp; // just return an empty array for spacing
    }
    
}
