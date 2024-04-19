/*
 * Utilizes the strategy pattern.
 * 
 * This class specifies which drawing strategy will be used and method execution passes though this class first,
 * because it maintains references to the concrete strategies
 * 
 */
public class DrawingContext {
    private DrawingStrategy strategy;
    public void setStrategy(DrawingStrategy s){ // setting to speciified concrete strategy
        strategy = s;
    }
    public void drawing(Matrix2 m, double x0, double y0, double x1, double y1){ // method just to call the concrete strategy method
        strategy.drawLine(m, x0, y0, x1, y1); 
        // Here we see that when the function drawing() is called it really calls the strategies drawLine()
        // method with the same parameters provided in the drawing() method.
    }
}
