import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bonusLife here.
 * 
 * @author (Sowmya Gowrishankar) 
 * @version (a version number or a date)
 */
public class bonusLife extends Bonus implements Game
{
    /**
     * Act - do whatever the BonusLife wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private ScoreDisplay display;
    
    public bonusLife(ScoreDisplay disp)
    {
        this.display = disp;
    }
    
    public void act() 
    {
        super.act();
    }    
    
    /**
     * increment life
     */
    public void bonus(Ironman ironman)
    {
        bonusLifeSound.setVolume(80);
        bonusLifeSound.play();
        //ironman.increaseLife();
        notifyObservers();
        getWorld().removeObject(this);
    }
    
    public void notifyObservers()
    {
        get_scoreboard().updateScore(this);
        display.updateDisplay(this);
    }
}
