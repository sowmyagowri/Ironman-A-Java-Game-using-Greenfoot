import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private int count = 10;
    
    public void act() 
    {
        if(count > 0)
        count--;
        else
        {
            World w = getWorld();
            w.removeObject(this);
        }
    }    
}
