import greenfoot.*;

/**
 * Write a description of class HelpCommand here.
 * 
 * @author Rucha Apte 
 * @version (a version number or a date)
 */

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