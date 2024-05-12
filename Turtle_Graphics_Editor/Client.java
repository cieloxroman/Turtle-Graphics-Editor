import java.util.*;
/*
 * Meant to interact with the user giving the option to play with the turtle graphics and make their own drawing 
 * which uses the command pattern, has a default canvas size, and allows commands like, show, trace, turn, move, undo and redo.
 * Then the user views a print of "***" which uses the composite design pattern. The composite design pattern has children that can create 
 * matrices with the words/numbers "*", "*","*", and "*".
 * Also I am using the naive strategy, so the lines may look a little wonky, but I found its the better option.
 * 
 * Please play through all the selections to view all the functionalities in this program. Or just type in 'q' then 'y' to see "** ***".
 * 
 */
public class Client {
    public static void main(String[] args) {
        PrintMatrix print = new PrintMatrix(); // use one print class to easily print matrices

        char[][] temp = new char[10][20];
        Matrix2 customCanvas = new Matrix2(temp);
        System.out.println("Number of rows = "+customCanvas.numrows());
        System.out.println("Number of columns = "+customCanvas.numcolumns());
        DrawingStrategy strategy = new NaiveStrategy(); // using the naive strategy for drawing.
        Sender send = new Sender(); // create a sender
        TurtleReciever reciever = new TurtleReciever(); // create a reciever

        Scanner obj = new Scanner(System.in);
        System.out.println("***Play with the turtle graphics yourself!***");

        while(true){
            
            System.out.println("Type in 'q' to quit,\n's' to show,\n'm' to move,\n't' to trace,\n'a' to turn,\n'u' to undo,\n'r' to redo");
            String choice = "";
            try {
                choice = obj.nextLine();
            } catch (Exception e) {
                System.err.println("You're just gonna leave me like that, SMH! You didn't even get to see my last trick, but fine, bye...");
                System.exit(0);
            }
            if(choice.equals("q")){ 
                // Could have used QuitCommand, but my program has more implementation to do so i don't want to quit just yet
                // but it still has that funcitonality
                System.out.println("Nice Drawing session!");
                break; 
            }else if(choice.equals("s")){
                // instantiate show commmand which after execution will call the recievers show() method
                send.setCommand(new ShowCommand(reciever, customCanvas));
                send.execute();
            }else if(choice.equals("m")){
                System.out.println("How many spaces would you like to move? (provide a whole (+) number)");
                String space = obj.nextLine();
                // instantiate move commmand which after execution will call the recievers move() method
                send.setCommand(new MoveCommand(reciever, Integer.parseInt(space), customCanvas));
                send.execute();
            }else if(choice.equals("t")){
                System.out.println("How many spaces would you like to trace? (provide a whole (+) number)");
                String space  = obj.nextLine();
                // instantiate trace commmand which after execution will call the recievers trace() method
                send.setCommand(new TraceCommand(reciever, Integer.parseInt(space), strategy, customCanvas));
                send.execute();
            }else if(choice.equals("a")){
                System.out.println("At which angle would you like to turn? (provide a whole (+) number)");
                String angle = obj.nextLine();
                // instantiate turn commmand which after execution will call the recievers turn() method
                send.setCommand(new TurnCommand(reciever, Integer.parseInt(angle)));
                send.execute();
            }else if(choice.equals("u")){
                // instantiate undo commmand which after execution will call the recievers undoing() method
                send.setCommand(new UndoCommand(reciever, customCanvas));
                send.execute();
            }else if(choice.equals("r")){
                // instantiate redo commmand which after execution will call the recievers redoing() method
                send.setCommand(new RedoCommand(reciever, customCanvas));
                send.execute();
            }else{
                System.out.println("GRRRR... Follow my instructions, pretty please...");
                System.out.println("If you want to see my next trick type in 'q' to quit");
            }
        }
        System.out.println("Okay, now ready for my last trick?! (type 'y' (yes) or 'n' (no))");
        while(true){
            String last = obj.nextLine();
            if(last.equals("y")){
                
                // create shape objects 
                Shape2 s = new S();
                Shape2 e = new E();
                Shape2 space = new Space();
                Shape2 three = new Three();
                Shape2 zero = new Zero();

                // create default matrices
                Matrix2 compCanvas = new Matrix2(5, 39);
                char[][] charTemp = new char[5][4];

                // create composite class to add shapes to
                TurtleComposite compDraw = new TurtleComposite(compCanvas);
            
                compDraw.add(s);
                compDraw.add(e);
                compDraw.add(space);
                compDraw.add(three);
                compDraw.add(s);
                compDraw.add(zero);

                compDraw.draw(charTemp, send, strategy); // execute draw() method to execute every draw() with the shape classes 
                System.out.println("\nTADA!");
                System.out.print(print.printMatrix(compCanvas)); // present
                
                break;
            }else if(last.equals("n")){
                System.out.println("oh pleaseee, you've got to see it! I won't let you leave till you agree to see!");
            }else{
                System.out.println("That wasn't an option, ;..(");
            }
        }
        System.out.println("\nThat was fun! Okay, bye now!");
    }
}
