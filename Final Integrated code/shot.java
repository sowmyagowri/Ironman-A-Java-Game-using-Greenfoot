import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shot here.
 * 
 * @author (Sowmya Gowrishankar) 
 * @version (a version number or a date)
 */
public class shot extends Objects implements Game
{
    protected GreenfootSound explosionSound;
    private ScoreDisplay scoredisplay;
    /**
     * Act - do whatever the shot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public shot(ScoreDisplay display)
    {
        this.scoredisplay = display;
        explosionSound = new GreenfootSound("explosionNave.wav");
    }
    
    public void act()
    {
        move(8);
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        } 
    }
    
    /**
     * Act - do whatever the Attack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
    */
    /**
     * When a shot is created in the world, move forward.
     * Check if the shot touches an enemy, if so both objects are removed
     * Also check if the shot left the world, if so the it is removed
    */
    
    
    public void notifyObservers()
    {
       get_scoreboard().updateScore(this); 
       scoredisplay.updateDisplay(this);
    }
}
