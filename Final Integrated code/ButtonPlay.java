import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButtonPlay here.
 * 
 * @author Rucha Apte 
 * @version (a version number or a date)
 */
public class ButtonPlay extends Button implements ButtonInvoker
{
    /**
     * Act - do whatever the ButtonStart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     ButtonCommand newButtonCommand;
    
    public void act() 
    {
        super.act();
        // Add your action code here.
    }
    
    public void click()
    {
        newButtonCommand.executeCommand();
        
    }
    public void setCommand(ButtonCommand newCmd)
    {
        this.newButtonCommand = newCmd;
    }
}
