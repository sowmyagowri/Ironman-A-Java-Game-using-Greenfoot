//import greenfoot.*;

public class HelpCommand implements ButtonCommand
{
    Receiver helpReceiver;
    
    public void setReceiver(Receiver newReceiver)
    {
        this.helpReceiver = newReceiver;
        
    }
    public void executeCommand()
    {
        helpReceiver.performAction();
        
    }
}