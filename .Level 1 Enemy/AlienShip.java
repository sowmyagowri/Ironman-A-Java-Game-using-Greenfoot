import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;
/**
 * Write a description of class Objects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AlienShip extends Objects implements Game
{
    private int shootCounter = 0;
    //private String ship_state;
   //private ScoreBoard sb = new ScoreBoard();
     private ScoreDisplay sd;
     
     /*public AlienShip()
     {}
     */
     
    public AlienShip(ScoreDisplay display)
    {
        this.sd = display;
    }
    public void act() 
    {
        // Add your action code here
        //display();
        move(-8);
        shoot();
        destroyShip();
        
        
    }    
    
    public void shoot()
    {
        shootCounter++;
        if(shootCounter >=100)
        {
            getWorld().addObject(new AlienBullet(), getX()-30, getY());
            System.out.println("Hello");
            shootCounter = 0;
        }
    }
    
    public void destroyShip()
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