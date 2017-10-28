import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
   
    private int targetx=0, targety=0,jeda=0;
    public static int dir=0,lives=5;
    private int vx=1;
    public boolean toRemove=false;
    //MainEnemy em=null;
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
        getWorld().addObject(new B(),getX(),getY());
        //System.out.println(lives);
        //Enemylives liv = (Enemylives)(getWorld().getObjects(Enemylives.class).get(0));
        lives--;
        //System.out.println(lives);
        if(lives==0)
        toRemove=true;
        else
        if(lives==1)
        toRemove=false;
        else
        if(lives==2)
        toRemove=false;
        else
        if(lives==3)
        toRemove=false;
        else
        if(lives==4)
        toRemove=false;
        
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
    if(jeda>0) jeda--;
        if(jeda%150==140) getWorld().addObject(new Fire(), getX(),getY());
        if(jeda%150==80) getWorld().addObject(new Context(new Object2()), getX(),getY());
        if(jeda==0) jeda=150;
    }
    public void act() 
    {
        
        if(!toRemove) move();
        else
        if(toRemove)
        getWorld().removeObject(this);
        
        
        
    }    
}


