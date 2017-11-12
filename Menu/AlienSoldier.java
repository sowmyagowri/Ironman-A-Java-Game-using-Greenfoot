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
        removeAlienSoldier();
    }    
    
    public void notifyObservers()
    {
           get_scoreboard().updateScore(this);
           scoredisplay.updateDisplay(this);
    }  
    
    public void removeAlienSoldier()
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
            //System.out.println("AlienSoldierhit");
            getWorld().removeObject(this);
       }
    }
}
