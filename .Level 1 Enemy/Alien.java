import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class AlienSoldier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Objects implements Game
{
    //private String soldier_state;
    //private ScoreBoard sb = new ScoreBoard();
     private ScoreDisplay sd;
     
     /*public Alien()
     {
     }*/
     
    public Alien(ScoreDisplay display)
    {
        this.sd = display;
    }
    
    public void act() 
    {
        move(-8);
        destroyAlien();
    }    
    
    public void destroyAlien()
    {
        if(isTouching(Bullet.class))
        {
            
            World w = getWorld();
            Explosion bomb = new Explosion();
            w.addObject(bomb, getX(), getY()); 
            removeTouching(Bullet.class);
            notifyObservers();
            sd.updateDisplay(this);
            w.removeObject(this);
            
        }
    }
    
    public void notifyObservers()
    {
           get_sb().updateScore(this);
    }
    
}
