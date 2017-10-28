import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IronMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IronMan extends Actor
{
    private int bulletCount = 0;
    //private static int numlives = 0;
    /**
     * Act - do whatever the IronMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        move_actor();
        shoot();
        bulletCount++;
 
    }    
    
    public void move_actor()
    {
        if(Greenfoot.isKeyDown("Up"))
        {
            setLocation(getX(), getY()-5);
        }
        else if(Greenfoot.isKeyDown("Down"))
        {
            setLocation(getX(), getY()+5);
        }
    }
    
    public void shoot()
    {
        World w = getWorld();
        
        if(Greenfoot.isKeyDown("space"))
        {
                if(bulletCount >= 10)
                {
                    w.addObject(new Bullet(), getX()+150, getY());
                    bulletCount = 0;
                }   
        }
        
    }
    
}
