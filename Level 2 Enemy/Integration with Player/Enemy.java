import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Enemy here.
 * 
 * @author (Sowmya Viswanathan) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
   private int targetx=0, targety=0,counter=0,vx=1,lives=50;
   public static int dir=0;
   public String str="object1";
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
       getWorld().addObject(new B(),getX(),getY());
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
   Enemy e=this;
   World world=getWorld();
    
   Handler s1 = new Object1();
   Handler s2 = new Object2();
   Handler s3 = new Object3();
    
   s1.setSuccessor(s2);
   s2.setSuccessor(s3);
    
   if(counter>0) counter--;
   if(counter%170==169) { s1.setObject(world,e,"OBJECT1"); }
   if(counter%170==110) { s1.setObject(world,e,"OBJECT2"); }
   if(counter%170==40) { s1.setObject(world,e,"OBJECT3"); }
   if(counter==0) counter=170;
   }
   public void act() 
   {
       if(!toRemove) 
        move();
       else
        getWorld().removeObject(this);
   }    
}