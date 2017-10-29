import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceShip extends Actor
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
            
            move(-4);
        }
         if(Greenfoot.isKeyDown("right"))
        {
             move(4);
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
               int ny = getY()+4;
               setLocation(x,ny) ;
        }
        if(jeda>0) jeda--;
        if(jeda==0) jeda=50;
    }    
}
