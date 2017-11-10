import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
   
    public void act() 
    {
        // Add your action code here.
        move(5);
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

