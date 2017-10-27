import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Objects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objects extends Actor
{
    private static int alienShipsHit = 0;
    public Objects(int X, int Y)
    {
        setLocation(X, Y);
    }
    public void act() 
    {
        // Add your action code here
        move(-8);
        destroyObj();
        displayScore();
    }    
    
    public void destroyObj()
    {
        if(isTouching(Bullet.class))
        {
            
            World w = getWorld();
            Explosion bomb = new Explosion();
            w.addObject(bomb, getX(), getY()); 
            removeTouching(Bullet.class);
            updateScore();
            w.removeObject(this);
            
        }
    }
    
    public void displayScore()
    {
        //setImage(new GreenfootImage("AlienShipsHit : " + alienShipsHit, 24, null, null));
    }
    
    public void updateScore()
    {
        alienShipsHit++;
    }

}
