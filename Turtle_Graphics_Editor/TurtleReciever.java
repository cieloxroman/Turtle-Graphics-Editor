/*
 * handle business logic and executions of commands
 */

import java.util.*;
//import java.util.List;

public class TurtleReciever {
    private ArrayList<TurtleReciever.Memento> undo = new ArrayList<>(); // keep a history of mememnto undos
    private ArrayList<TurtleReciever.Memento> redo = new ArrayList<>(); // and a history of memento redos
    double angle;
    double oldx;
    double oldy;
    //double newx; 
    //double newy;
    
    TurtleReciever(){
        angle = 0.0;
        oldx = 0;
        oldy = 0;
    }
    public void turn(int degree){
        double temp = angle;
        angle = (angle+degree)%360; // stays within range 0 to 360
        System.out.println("Turned from "+temp+" degrees to "+angle+" degrees");
    }
    public void quit(){
        System.out.println("Bye");
        System.exit(0);
    }
    public void show(Matrix2 canvas){
        PrintMatrix temp = new PrintMatrix();
        String result = temp.printMatrix(canvas);
        System.out.print("Heres your current canvas: \n"+result);
        System.out.println("Current angle = "+angle);
        System.out.println("Current position = ("+oldx+","+oldy+")");
    }
    public void move(Matrix2 canvas, int distance){
        double newx = (int)(distance * Math.cos(Math.toRadians(angle)));
        double newy = (int)(distance * Math.sin(Math.toRadians(angle)));
        System.out.println("Moved from: ("+oldx+","+oldy+")"+" to "+"("+newx+","+newy+")");
        newx = (int)newx + oldx;
        newy = (int)newy + oldy;
        oldx = newx;
        oldy = newy;
        save(canvas);
    }
    public void trace(Matrix2 canvas, double distance, DrawingStrategy strategy){
        double newx =  distance * Math.cos(Math.toRadians(angle));
        double newy =  distance * Math.sin(Math.toRadians(angle));
        
        newx = (int)newx + oldx;
        newy = (int)newy + oldy;
        
        System.out.println("columns = "+canvas.numcolumns());
        System.out.println("rows ="+canvas.numrows());
        if(newx>=canvas.numrows()){
            newx = canvas.numrows()-1;
        }
        if(newy>=canvas.numcolumns()){
            newy = canvas.numcolumns()-1;
        }
        if(newx<0){
            newx = 0;
        }
        if(newy<0){
            newy = 0;
        }
        System.out.println("Traced from: ("+Math.round(oldy)+","+Math.round(oldx)+")"+" to "+"("+(int)newy+","+(int) newx+")");

        strategy.drawLine(canvas, oldx, oldy, newx, newy); // Use NaiveStrategy for line drawing
        oldx = newx;
        oldy = newy;
        save(canvas);
    }
    public static class Memento{
        private char[][] canvas;
        private double angle;
        private double x;
        private double y;
        Memento(Matrix2 m, double angle, double x, double y){
            this.canvas = m.getArray();
            this.angle = angle;
            this.x = x;
            this.y = y;
        }
        private char[][] getMatrix(){
            return this.canvas;//new Matrix2(canvas);
        }
        private double getAngle(){
            
            return angle;
        }
        private double getX(){
           
            return x;
        }
        private double getY(){
            
            return y;
        }
    }
    public void save(Matrix2 m){
        System.out.println("***Work saved***");
        Memento temp = new Memento(m, angle, oldx, oldy);
        
        undo.add(temp);
    }
    public void undoing (Matrix2 matrix){
        System.out.println("***Undoing***");
        int index;
        if(undo.isEmpty()){
            System.out.println("No more undos available");
        }else{
            if(undo.size()<2){
                System.out.println("Less than 2");
                index = 0;//undo.size()-1;
                Memento tempM = undo.remove(index); // list should be empty now
                redo.add(tempM); // add to redo
                char[][] temp = new char[matrix.numrows()][matrix.numcolumns()]; // create empty matrix
                // start over
                this.angle = 0.0; 
                this.oldx = 0.0;
                this.oldy = 0.0;
                matrix.setter(temp); // set to empty matrix
            }else{
                index = undo.size()-2; // get second to last matrix
                Memento temp = undo.get(index);
                redo.add(undo.remove(undo.size()-1));
                this.angle = temp.getAngle();
                this.oldx = temp.getX();
                this.oldy = temp.getY();
                matrix.setter(temp.getMatrix()); // set eqaul matrix second to last in undo list
            }
        }
    }
    public void redoing (Matrix2 matrix){
        if(redo.size()<1){
            System.out.println("Looks like there is no redos available");
        }else{
            System.out.println("***Redoing***");
            Memento temp = redo.remove(redo.size()-1); // remove last index and save
            this.angle = temp.getAngle();
            this.oldx = temp.getX();
            this.oldy = temp.getY();
            matrix.setter(temp.getMatrix()); // set matrix to last redo
            undo.add(temp);
        }
    }
}


