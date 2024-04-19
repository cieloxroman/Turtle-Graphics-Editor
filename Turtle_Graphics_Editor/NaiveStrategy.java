/*
 * "It is here that the points have already been ordered so that x1>x0" - wiki
 * Works well when dx>=dy but other than that the line is not optimal for drawing because lines become sparse at certain angles. 
 */
public class NaiveStrategy implements DrawingStrategy{

    @Override
    public void drawLine(Matrix2 m, double x0, double y0, double x1, double y1) {
        double dx = x1-x0;
        double dy = y1-y0;
        // avoid integer division by zero
        if(dx == 0){
            int yMin = (int) Math.min(y0, y1);
            int yMax = (int) Math.max(y0, y1);
            for(int i = yMin; i<=yMax; i++){
                m.setCell((int) x0, i, '#');
            }
        }else if(x0>x1){ // handle if x0 is larger which means it will be a negative number if it is not caught at dx==0 condition
            double y;
            for(int x = (int)x0; x>=(int)x1; x--){
                y = y0 + dy * (x-x0) / dx;
                m.setCell(x,(int)y, '#');
            }
        }else{ // handle if x1 is larger
            double y;
            for(int x = (int)x0; x<=(int)x1; x++){
                y = y0 + dy * (x-x0) / dx;
                m.setCell(x,(int)y, '#');
            }
        }  
    }
}
