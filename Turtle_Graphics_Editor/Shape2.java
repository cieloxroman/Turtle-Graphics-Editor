/*
 * Interface for composite component. Specifying the methods to implement in container class and in concrete leaves
 */
public interface Shape2 {
    public Matrix2 draw(char[][] chr, Sender send, DrawingStrategy strategy);
}
