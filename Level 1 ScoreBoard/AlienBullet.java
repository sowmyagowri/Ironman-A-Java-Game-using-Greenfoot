import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AlienBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AlienBullet extends Actor
{
      
    public void act() 
    {
        // Add your action code here.
        move(-10);
        remove();
    }    
    
    public void remove()
    {
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }   
    }     
}
