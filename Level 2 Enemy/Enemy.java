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
    public static int dir=0;
    private int vx=1,lives=50,x,y;
    public boolean toRemove=false;
    //MainEnemy em=null
    
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
        remEnemy();
        if(getLives()==0)
        toRemove=true;
        else
        toRemove=false;
       
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
    Enemy e=this;
    World world=getWorld();
    Strategy s2 = new Object2();
    Strategy s3 = new Object3();
    s2.setSuccessor(s3);


        if(jeda>0) jeda--;
        if(jeda%150==140) getWorld().addObject(new Fire(), getX(),getY());
        if(jeda%150==80) { s2.setObject(world,e);
        s2.fly("ob2",world, e); }
        if(jeda==0) jeda=150;
    }
    public void act() 
    {
        
        if(!toRemove) move();
        else
        getWorld().removeObject(this);
        
        
        
    }    
}


