import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;
/**
 * Write a description of class Objects here.
 * 
 * @author (Avni Gulati) 
 * @version (a version number or a date)
 */
public class AlienShip extends Objects implements Game
{
    private int shootCounter = 0;
    private ScoreDisplay scoredisplay;
     
    public AlienShip(ScoreDisplay display)
    {
        this.scoredisplay = display;
    }
    public void act() 
    {
        move(-8);
        shoot();
        removeAlienShip();
    }    
    
    public void shoot()
    {
        shootCounter++;
        if(shootCounter >=100)
        {
            getWorld().addObject(new AlienBullet(), getX()-30, getY());
            shootCounter = 0;
        }
    }
    
    public void removeAlienShip()
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
            System.out.println("Alienshiphit");
            getWorld().removeObject(this);
       }
    }
    
    public void notifyObservers()
    {
        get_scoreboard().updateScore(this);
        scoredisplay.updateDisplay(this);
    }

}