import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket_Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket_Enemy extends Actor
{
    private int targetx=0, targety=0,jeda=0;
    private boolean toRemove=false;
    public void addedToWorld(World MyWorld)
    {
            targetx=getX();
            targety=getY();
    }
    
    
    public void act() 
    {
         if(Greenfoot.isKeyDown("left"))
        {
            
            move(-3);
        }
         if(Greenfoot.isKeyDown("right"))
        {
             move(3);
        }
        if(Greenfoot.isKeyDown("up"))
        {
           int x = getX();
           int y = getY();
           int ny  = getY()-3;
           setLocation(x,ny) ;
        }
         if(Greenfoot.isKeyDown("down"))
        {
               int x = getX();
               int y = getY();
               int ny = getY()+3;
               setLocation(x,ny) ;
        }
        if(jeda>0) jeda--;
        if(jeda==0) jeda=50;
    }    
}
