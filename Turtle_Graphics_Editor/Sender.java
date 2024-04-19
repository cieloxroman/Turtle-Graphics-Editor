/*
 * Is the invoker of the command strategy and actually executes the specified commands execute() method
 */
public class Sender {
    // invoker
    private Command command;
    public void setCommand(Command command){
        this.command = command;
    }
    public void execute(){
        command.execute();
    }
}
