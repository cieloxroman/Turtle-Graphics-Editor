import java.util.*;
/*
 * Is the conainter class of the composite pattern
 * Saves the children/ adds leaves.
 * When draw is overriden and executed it executes the draw() method for each of those children
 * The children execute their drawing methods and each on returns a matrix with the character they were to implemenent
 * Then the turtle composite draw() method adds those matrix values into to a final matrix which is the accumulation of all those matrices
 * Finally returns a proper matrix to be later printed
 */
public class TurtleComposite implements Shape2{
    ArrayList<Shape2> children = new ArrayList<>();
    char[][] outputCanvas;
    Matrix2 canvas;
    TurtleComposite(Matrix2 canvas){
        this.canvas = canvas;
        this.outputCanvas = canvas.getArray();
    }
    @Override
    public Matrix2 draw(char[][] character, Sender send, DrawingStrategy strategy) {
        Matrix2 temp;
        
        int index = 0;
        for(Shape2 chr : children){
        
            temp = chr.draw(character, send, strategy);
        
            for(int i = 0; i<temp.getArray().length; i++){
                System.arraycopy(temp.getArray()[i], 0, outputCanvas[i], index, temp.getArray()[i].length);
            }
            index += temp.getArray().length;            
        }
        canvas.setter(outputCanvas);
        return canvas;
    }
    public void add(Shape2 chr){
        children.add(chr);
    }
    public void remove(Shape2 chr){
        children.remove(chr);
    }
    
}
