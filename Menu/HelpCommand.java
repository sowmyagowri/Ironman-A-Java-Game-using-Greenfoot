import greenfoot.*;

public class HelpCommand implements ButtonCommand
{
    Reciever helpReciever;
    
    public void setReciever(Reciever newReciever)
    {
        this.helpReciever = newReciever;
        
    }
    public void executeCommand()
    {
        helpReciever.performAction();
        
    }
}