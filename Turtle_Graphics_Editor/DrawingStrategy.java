/**
 * DrawingStrategy interface to specify what exact methods each concrete strategy must have.  
 */
public interface DrawingStrategy {
    public void drawLine(Matrix2 m, double x0, double y0, double x1, double y1);
    
}
