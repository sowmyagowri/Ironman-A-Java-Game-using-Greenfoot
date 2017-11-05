import greenfoot.*;

public class PlayCommand implements ButtonCommand
{
    Reciever playReciever;
    
    public void setReciever(Reciever newReciever)
    {
        this.playReciever = newReciever;
        
    }
    public void executeCommand()
    {
        playReciever.performAction();
        
    }
}