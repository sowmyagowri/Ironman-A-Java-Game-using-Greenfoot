import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButtonHelp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonHelp extends Button implements ButtonInvoker
{    
    private Help help;
    private ButtonCommand newButtonCommand;
    public ButtonHelp()
    {
        help = new Help();
    }
    public Help getHelp()
    {
        return help;
    }
    
    public void act() 
    {
        // Add your action code here.
//                if (Greenfoot.mouseClicked(this))
//        {
//            Greenfoot.setWorld(new Help());
//        }
        super.act();
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
