import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class AlienSoldier here.
 * 
 * @author (Avni Gulati) 
 * @version (a version number or a date)
 */
public class AlienSoldier extends Objects implements Game
{
    private ScoreDisplay scoredisplay;
    
    public AlienSoldier(ScoreDisplay display)
    {
        this.scoredisplay = display;
    }
    
    public void act() 
    {
        move(-8);
        if(getX() == 0)
            getWorld().removeObject(this);
    }    
    
    public void notifyObservers()
    {
           get_scoreboard().updateScore(this);
    }  
}
