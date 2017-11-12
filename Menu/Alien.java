import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class AlienSoldier here.
 * 
 * @author (Avni Gulati) 
 * @version (a version number or a date)
 */
public class Alien extends Objects implements Game
{
    private ScoreDisplay scoredisplay;
    
    public Alien(ScoreDisplay display)
    {
        this.scoredisplay = display;
    }
    
    public void act() 
    {
        move(-8);
        removeAlien();
    }    
    
    public void notifyObservers()
    {
        get_scoreboard().updateScore(this);
        scoredisplay.updateDisplay(this);
    }
    
    public void removeAlien()
    {
        if(isTouching(shot.class))
       {
            //AlienShip as = (AlienShip)getOneIntersectingObject(AlienShip.class);
            //explosionSound.play();
            Explosion bomb = new Explosion();
            getWorld().addObject(bomb, getX(), getY()); 
            removeTouching(shot.class);
            //getWorld().addObject(new Boom(), getX(), getY());
            notifyObservers();
            //System.out.println("Alienhit");
            getWorld().removeObject(this);
       }
    }
    
}
