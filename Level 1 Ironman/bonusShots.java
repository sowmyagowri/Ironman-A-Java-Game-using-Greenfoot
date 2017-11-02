import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bonusShots here.
 * 
 * @author (Sowmya Gowrishankar) 
 * @version (a version number or a date)
 */
public class bonusShots extends Bonus
{
    /**
     * Act - do whatever the BonusShot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
    
    /**
     * Increments Shots
     */
    public void bonus(Ironman ironman)
    {
        bonusShotsSound.play();
        ironman.setNumShots(ironman.getNumShots() + 10);
        ironman.setCurrentState(ironman.gethasShotState());
        getWorld().removeObject(this);
    }
}
