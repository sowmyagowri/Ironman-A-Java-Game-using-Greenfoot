import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Enemy_State here.
 * 
 * @author (Sowmya Viswanathan) 
 * @version (a version number or a date)
 */
public class Enemy_State extends Objects
{
   
    private int targetx=0, targety=0,counter=0,vx=1,lives=50;
    public static int dir=0;
    public boolean toRemove=false;
    
    public void checkwalls()
    {
        if(isAtEdge()&&dir==0)
        {
            setLocation(getX(),getY()-50);
            dir=1;                  
        }
        if(isAtEdge()&&dir==1)
        {
            setLocation(getX(),getY()+50);
            dir=0;                  
        }
    }
    public void destroy()
    {
        getWorld().addObject(new Boom(),getX(),getY());
        remEnemy();
        if(getLives()==0) toRemove=true;
        else toRemove=false;       
    }
    public void remEnemy()
    {
        lives--;
    }
    public int getLives()
    {
      return lives;
    }
    
    public void move()
    {
    if(dir==0)
    {
        setLocation(getX(),getY()+vx);
        checkwalls();
    }
    if(dir==1)
    {
        setLocation(getX(),getY()-vx);
        checkwalls();
    }
       
    }
    public void act() 
    {
        
        if(!toRemove) 
            move();
        else
            getWorld().removeObject(this);
        
    }    
}
